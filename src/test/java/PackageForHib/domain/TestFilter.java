package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import PackageForHib.domain.dataFilter.Area;
import PackageForHib.domain.dataFilter.TreeC;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.spi.FilterDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestFilter {

    @Test
    public void checkFilter(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();
        Filter filter = session.enableFilter("text_filter");
//        filter.validate(); // викликає HibernateException якщо до цього моменту не було встановлено параметер
//        filter.setParameterList() Также можно передать список аргументов с по-
//мощью метода setParameterList(); это очень удобно, если ограничение SQL содер-
//жит выражение с операторами, работающими на множествах (например, с опера-
//тором IN).
        filter.setParameter("textpar","Fas");
        List<TreeC> treeC = session.createQuery("SELECT t FROM TreeC t WHERE 12 = 11").getResultList();
        System.out.println(treeC);

        FilterDefinition definition = filter.getFilterDefinition();
        String s = definition.getDefaultFilterCondition();
        System.out.println(s);
//        System.out.println(definition.getFilterName());
//        System.out.println(definition.getParameterNames());
//        System.out.println(definition.getParameterTypes());
//        System.out.println(definition.getParameterType("textpar"));


        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void collectionFilter(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();
        Filter filter = session.enableFilter("text_filter");
        filter.setParameter("textpar","YES");
        Area area = session.find(Area.class,221);
        System.out.println(area.getTreeCSet());

        session.getTransaction().commit();
        session.close();
    }
}
