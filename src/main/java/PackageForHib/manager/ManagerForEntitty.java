package PackageForHib.manager;

import PackageForHib.domain.EntityForTestLazyCollection.ThirdEntity;
import PackageForHib.domain.Login;
import PackageForHib.domain.Message;
import PackageForHib.domain.dao.GenericDaoClass;
import PackageForHib.manager.*;

import javax.persistence.*;
import javax.persistence.FlushModeType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.UserTransaction;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.*;

public class ManagerForEntitty {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Message");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        GenericDaoClass<Message,Long> genericDaoClass = new GenericDaoClass<Message,Long>(Message.class);
        genericDaoClass.setEntityManager(entityManager);
        Message m = genericDaoClass.findById(533l);
        System.out.println(m);
//        Message item = entityManager.find(Message.class, 21L);
//        item.setText("New Nam2e");
//
//        entityManager.setFlushMode(FlushModeType.COMMIT);
//        System.out.println("Вивід "+entityManager.createQuery("select m.text from Message m where m.id = :id")
//                        .setParameter("id", 21L).getSingleResult());

        entityManager.getTransaction().commit();


//        Query query = entityManager.createQuery("SELECT m FROM Message m")
//                .setHint(
//                        org.hibernate.annotations.QueryHints.READ_ONLY,
//                        true
//                ); // буде повертати екземпляри лише для читання


//        entityManager.getTransaction().begin();
//        Login login = new Login();
//        login.setId(15);
//        login.setPassword("Hellloooo");
//        login.setLoginDate(new Date(140,20,21));
//        entityManager.persist(login);
//        entityManager.getTransaction().commit();
//        entityManager.close();

//
//        entityManager.getTransaction().begin();
//////        List<Message> list = entityManager.createQuery("SELECT m FROM Message AS m WHERE id = 1").getResultList();
//        Query query = entityManager.createNamedQuery("myNewQuery"); /** не розумію чому помилка!!!  Виявилось, що код працює
//          хоча і позначається як помилка ХЗ**/
//        List<Message> messages = query.getResultList();
//        System.out.println(messages);
//        entityManager.getTransaction().commit();
//        entityManager.close();





//        for (Message m:
//             list) {
//            System.out.println(m);
//        }


//        Message massage = new Message();
//        massage.setText("testingMessage!!!!!!");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(massage);
//        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
