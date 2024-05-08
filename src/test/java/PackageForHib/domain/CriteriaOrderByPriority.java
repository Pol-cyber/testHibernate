package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.*;

public class CriteriaOrderByPriority {

    @Test
    public void orderPriority(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        Query<Message> q = session.createQuery("SELECT m FROM Message m");
        sessionFactory.addNamedQuery("checkQ",q);

        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Message> query = cb.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);

        Expression<Boolean> booleanExpression = cb.like(root.get(Message_.TEXT),"g%");

        query.select(root).orderBy(cb.asc(cb.selectCase().when(booleanExpression,0).otherwise(1)),cb.asc(root.get(Message_.TEXT)));

        System.out.println(session.createQuery(query).getResultList());

        session.getTransaction().commit();
        session.close();
    }

}
