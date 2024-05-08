package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestScrollableResult {
    @Test
    public void testScroll(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();


        session.getTransaction().begin();
        ScrollableResults scrollableResults = session.createQuery("SELECT m.id,m.text FROM Message m").scroll(ScrollMode.SCROLL_INSENSITIVE);
//        scrollableResults.last();
//        List<Message> messageList = session.createQuery("SELECT m FROM Message m").getResultList();
//        System.out.println(messageList);
//        List<Message> messageList1 = session.createQuery("SELECT m.id,m.text FROM Message m").getResultList();
//        System.out.println(messageList1);
//        for(int  i  = 0; i <3 ; i++){
//            scrollableResults.next();
//        }
        scrollableResults.next();
        System.out.println(scrollableResults.getRowNumber()+1); // відлік починається з нуля
//        System.out.println(scrollableResults.getString(1));
        System.out.println(scrollableResults.get(0));

        scrollableResults.close();
        session.getTransaction().commit();
        session.close();
    }
}
