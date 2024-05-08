package PackageForHib.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.sql.*;

public class CheckDataValue {
    // При извлечении даты из базы данных Hibernate использует подкласс JDBC,
    //потому что типы базы данных более точные, чем java.util.Date. Тип java.util.
    //Date обеспечивает точность до миллисекунды, тогда как тип java.sql.Timestamp
    //включает информацию о наносекундах, которые могут храниться в базе данных.
    //Hibernate не будет отсекать эту информацию, чтобы вместить значение в java.
    //util.Date. Такое поведение может привести к проблемам, если попытаться срав-
    //нить значения типа java.util.Date, используя метод equals() – он не симметричен
    //с методом equals() подкласса java.sql.Timestamp.
    @Test
    public void testAutoChangeDate(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Cat cat1 = new Cat();
        cat1.setName("Мурз");
        Date date = new Date();
        cat1.setDateBorn(date);
        System.out.println(date);
        session.persist(cat1);
        Cat cat2 = session.find(Cat.class,cat1.id);
        Date date1 = new Timestamp(date.getTime());
        Assertions.assertEquals(date,date1);
        System.out.println(date.equals(cat2.getDateBorn()));
        System.out.println(date +"    "+ date1); // як не пробую помилки не виникає, хоча в базі даних і правда
        // вписано із додатковими значеннями мілісекунди 2023-03-25 15:27:38.909000  от так,  но коли отримується перетворюється
        // на звичайний Date без них!!!!
        session.getTransaction().commit();
    }
}
