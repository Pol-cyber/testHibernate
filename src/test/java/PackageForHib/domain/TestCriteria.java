package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import PackageForHib.domain.castomReturnObjectInQuery.MyBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.*;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestCriteria {

    // Интересна особливість CriteriaBuilder в  тому що буде використовуватись в любій session (контекст хранения першого рівня)
    // для цього SessionFactory
    // (контекст хранения другого рівня)
    @Test
    public void testSubQuery(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        session.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        Root<Message> root  = criteriaQuery.from(Message.class);
        Subquery<Double> catSubquery = criteriaQuery.subquery(Double.class);
        Root<Cat> catRoot =  catSubquery.from(Cat.class);
        catSubquery.select(criteriaBuilder.avg(catRoot.get(Cat_.ID)));
        criteriaQuery.select(root).where(criteriaBuilder.lt(catSubquery,root.get(Message_.ID)));

        System.out.println(session.createQuery(criteriaQuery).getResultList());

        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void constructMyTypeInCriteria(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        session.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<MyBean> myBeanCriteriaQuery = criteriaBuilder.createQuery(MyBean.class);
        Root<Message> r = myBeanCriteriaQuery.from(Message.class);
        myBeanCriteriaQuery.select(criteriaBuilder.construct(MyBean.class,r.get(Message_.ID),r.get(Message_.TEXT)));

        List<MyBean> myBeans = session.createQuery(myBeanCriteriaQuery).getResultList();

        System.out.println(myBeans);


        session.getTransaction().commit();
        session.close();
    }




    // Тут я тещу criteria hibernate яка є застарілою  і основна відмінність в можливості викорстовувати явний sql код
    @Test
    public void testHibernateDipricateCriteria(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        session.getTransaction().begin();

//        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Message.class); // створює criteria що не належить ні одному
//        контекту хранения
        Criteria criteria = session.createCriteria(Message.class);
        List<String> strings = criteria.setProjection(Projections.sqlProjection("text as txt",
                new String[]{"txt"},new Type[]{StandardBasicTypes.STRING})).list();

        System.out.println(strings);
        session.getTransaction().commit();
        session.close();
    }
}
