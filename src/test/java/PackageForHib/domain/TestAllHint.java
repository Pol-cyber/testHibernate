package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.QueryHints;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestAllHint {

    @Test // всі hints - 418ст.
    public void testReadOnly(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();


        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        Query<Message> q = session.createQuery("SELECT m FROM Message m");
        sessionFactory.addNamedQuery("checkQ",q);

        session.getTransaction().begin();

        Query<Message> query = session.createQuery("SELECT m FROM Message m",Message.class).setHint(QueryHints.READ_ONLY,true);

        List<Message> m = query.getResultList();
        for(int i = 0; i < 4; i++){
             m.get(i).setText(i+" new");
        }

        session.setReadOnly(m.get(3),false);

        m.get(3).setText("HSzxxxxxxxxx");



        session.getTransaction().commit();
        session.close();
    }
}
