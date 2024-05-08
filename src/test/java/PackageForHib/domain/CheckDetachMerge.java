package PackageForHib.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckDetachMerge {

    @Test
    private void testDetach(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();

        Message message = new Message("SD");

        session.persist(message);

//        Message message = session.find(Message.class,21L);
//        message.setText("dsaxz");
//        session.flush();

        session.detach(message); // після перевірки прийшов до виводу, що будуть виконанні лише ті операції які напряму викликають
        // sql код до виклику detach (тобто якщо викликати flush() і синхронізувати дані, то ця операція буде виконана, а якщо
        // без і запит буде виконуватись лише після commit() - буде проігноровано

        session.getTransaction().commit();
    }


    @Test
    public void testMerge(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();

        Message message = session.find(Message.class,21L);

        session.detach(message);

        message.setText("AFTER detach");

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();

        // ІНТЕРЕСНА ОСОБЛИВІСТЬ merge()
        // Если в контексте хранения (session) не будет найден ни один хранимый экземпляр с та-
        //ким же идентификатором и поиск в базе данных по идентификатору не даст ре-
        //зультатов, Hibernate создаст новый объект User. Затем выполнит копирование от-
        //соединенного экземпляра поверх нового экземпляра и поместит его в базу данных
        //при синхронизации контекста хранения с базой данных
        //Если экземпляр, переданный в метод merge(), является не отсоединенным,
        //а временным (у него отсутствует значение идентификатора), Hibernate создаст
        //новый объект User, скопирует поверх временный объект User, сделает его храни-
        //мым и вернет обратно. Проще говоря, операция merge() может работать с отсоеди-
        //ненными и временными экземплярами сущностей. Hibernate всегда возвращает
        //в результате хранимый экземпляр.
        Message message1 = (Message) session.merge(message);

        // session.saveOrUpdate(message); // цей метод переключить іменно екземпляр message тобто не прийдеться отримувати і
        // використовувати тільки нову ссилку, однак вместо этого мы советуем
        //полагаться на операцию слияния, поскольку она стандартизована и поэтому легче
        //интегрируется с другими фреймворками. Кроме того, если отсоединенный экзем-
        //пляр не был изменен, вместо UPDATE операция слияния выполнит только инструк-
        //цию SELECT. Если вам интересно, метод saveOrUpdate()  интерфейса Session дела-
        //ет то же самое, что и merge() в EntityManager. (Hibernate книга ст.297) (Copy)

        Assertions.assertEquals(message1.getText(),"AFTER detach");

        session.getTransaction().commit();
        session.close();

    }
}
