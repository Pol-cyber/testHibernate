package PackageForHib.domain;

import PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.Host;
import PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.proxy.HibernateProxyHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.JoinColumn;

public class WorkWithProxyObject {

    @Test
    public void checkClassProxy(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();

        Message message = session.getReference(Message.class,373L);

        Assertions.assertNotEquals(message.getClass(),Message.class);

        Assertions.assertEquals(HibernateProxyHelper.getClassWithoutInitializingProxy(message),Message.class);

        session.detach(message);

//        message.getId(); //  викликає LazyInitializationException
//
//        message.getText(); //  викликає LazyInitializationException

        session.getTransaction().commit();

    }


    // Перевірка особливості присвоєння прокси обьекта як зовнішній ключ без його ініціалізації
    @Test
    public void checkInputINOtherObjectProxy(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        Host host = session.getReference(Host.class,121);

        Player player = new Player(host); // host є прокси обьектом
        // insert into Player values (?, ? ,? , ...)
        // також не перевіряв як це може працювати із силкою не на первинний ключ, а на унікальне значення
        session.persist(player);

        session.getTransaction().commit();

        session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        Player player1 = session.find(Player.class,player.getId());

        Assertions.assertEquals(121,player1.getHost().getId());

        session.getTransaction().commit();

    }
}
