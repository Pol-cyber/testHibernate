package PackageForHib.domain;

import PackageForHib.domain.myview.ViewMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;

public class CheckSubSelect {

    // Тест для використання классу @SubSelect donain/myview/ViewMessage (ст.109)
    @Test
    public void testViewMessage(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").
                build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Message message = session.find(Message.class,12L);
        message.setText("NewText2");
//        ViewMessage viewMessage = session.find(ViewMessage.class,12L); // перший метод (При загрузке по идентификатору
//синхронизация не происходит) тобто змінені дані в рядках 23, 24 не будуть відображені тут, а при використанні Query будуть
        Query query = session.createQuery("SELECT vm FROM ViewMessage vm WHERE vm.id = :id");
        ViewMessage viewMessage = (ViewMessage)query.setParameter("id",12L).getSingleResult();
        Assertions.assertNotNull(viewMessage);
        System.out.println(viewMessage);
        session.getTransaction().commit();

    }
}
