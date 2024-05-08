package PackageForHib.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

public class CreateBlob {

    @Test
    public void CreateBlobObject(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        HereByte hereByte = new HereByte();
        String s = "Hello My People";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
        Clob clob = session.getLobHelper().createClob(bufferedReader,s.getBytes().length);
        hereByte.setName(clob);
        session.persist(hereByte);
        session.getTransaction().commit();
    }

    @Test
    public void takeClobObject(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        HereByte hereByte = session.find(HereByte.class,27);
        Clob clob = hereByte.getName();
        try {
            Reader reader = clob.getCharacterStream();
            int c;
            String text ="";
            while( (c = reader.read()) != -1){
                System.out.printf(Character.toString(c));
                text += Character.toString(c);
            }
            Assertions.assertEquals("Hello My People",text);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        session.getTransaction().commit();
    }
}
