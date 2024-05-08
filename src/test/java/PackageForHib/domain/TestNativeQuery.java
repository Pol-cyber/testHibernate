package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import java.util.List;

public class TestNativeQuery {

    @Test // якщо значення сутності має іншу назву чим стовпець який отримався із даного запиту то буде
    // викликано помилку для цього необхідно створити власний спосіб відображення SqlResultSetMapping
    public void testMyMappingQuery(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        // якщо правильно розумію то регістр в AS ігнорується і як би не написав значення воно буде рівне
        // @FieldResult(name = "text", column = "TextNew")
        Query m = session.createNativeQuery("SELECT id,'Action: ' || text AS TextNew FROM Message m WHERE m.id = ?","MessageResult");
        m.setParameter(1,437L);
        Message me = (Message) m.getSingleResult();
        System.out.println(me);

        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void testToTwoEntity(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        List<Object[]> l = session.createNativeQuery("SELECT h.id AS ID_Host,h.text as TEXT,p.id AS ID_Player, p.host_id as Host_ID FROM " +
                "host h join player p on h.id = p.host_id","HostResult").getResultList();

//        List<Object[]> l = session.createNativeQuery("SELECT h.id AS ID_Host, h.text AS TEXT, p.id AS ID_Player, p.host_id AS ID_Host FROM " +
//                "player p JOIN host h ON h.id = p.host_id","HostResult").getResultList();

        session.getTransaction().commit();
        session.close();
    }
}
