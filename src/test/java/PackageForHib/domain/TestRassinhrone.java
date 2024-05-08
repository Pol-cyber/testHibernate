package PackageForHib.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

//рассинхронизированный контекст хранения
public class TestRassinhrone {
    
    @Test
    public void testR(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Session session1 = sessionFactory.openSession();

        Message message =  new Message();
        message.setText("Newmessage");
        session1.persist(message);
        Message message1 = session1.find(Message.class,373L);
        session1.remove(message1);


        session.getTransaction().begin();
        if(!session1.isJoinedToTransaction()){
            session1.joinTransaction();
        }
        session.getTransaction().commit();
        session1.close();
        session.close();
    }
}
