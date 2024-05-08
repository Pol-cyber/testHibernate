package PackageForHib.domain;

import PackageForHib.domain.OptimisticLockTest.LongVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class PessimisticBlockTest {

    @Test
    public void testPesimisticRead(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Session session1 = sessionFactory.openSession();

        session.getTransaction().begin();
        Map<String,Object> hints = new HashMap<>();
        hints.put("javax.persistence.lock.timeout",5000);
        LongVersion longVersion = session.find(LongVersion.class,181, LockModeType.PESSIMISTIC_READ,hints);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        session1.getTransaction().begin();
        System.out.println("Друга транзакція");
        try {
            LongVersion longVersion1 = session1.find(LongVersion.class, 181,LockModeType.PESSIMISTIC_READ);
            System.out.println("Отримав елемент");
            longVersion1.setName("УЦЦЦЦ");
            session1.getTransaction().commit();
            session1.close();
        } catch (LockTimeoutException e){
            System.out.println(e);
        }
        System.out.println("Сюда зайде якщо longVersion1 закоментовано");
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testPesimisticWrite(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Session session1 = sessionFactory.openSession();

        session.getTransaction().begin();
        Map<String,Object> hints = new HashMap<>();
        hints.put("javax.persistence.lock.timeout",5000);
        LongVersion longVersion = session.find(LongVersion.class,181, LockModeType.PESSIMISTIC_WRITE,hints);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        session1.getTransaction().begin();
        System.out.println("Друга транзакція");
        try {
            LongVersion longVersion1 = session1.find(LongVersion.class, 181);
            System.out.println("Отримав елемент");
            System.out.println(longVersion1.getName());
//            longVersion1.setName("УЦЦЦЦ");
            session1.getTransaction().commit();
            session1.close();
        } catch (LockTimeoutException e){
            System.out.println(e);
        }
        System.out.println("Сюда зайде якщо longVersion1 закоментовано");
        session.getTransaction().commit();
        session.close();
    }

}
