package PackageForHib.domain;

import PackageForHib.domain.entityWithRelationship.withInheritClass.Maid;
import PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails;
import PackageForHib.domain.typeInheritEntity.fourthMethod.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFetch {
    
    @Test
    public void testLazy(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").
                build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();
//        Maid maid = new Maid();
//
//        CreditCard creditCard = new CreditCard("30021242","2","2022");
//
//        maid.setBillingDetails(creditCard);
//
//        session.persist(creditCard);
//
//        session.persist(maid);

//        Maid maidTest = session.find(Maid.class, maid.id); //Якщо правильно зрозумів то в програмі може існувати
        // тільки один об’єкт строки таблиці. Кожен раз коли отримую об'єкт за допомогою find то скільки би не
        // створював кожен ссилається на одну і ту же область в памяті, таким чином якщо я використаю maid.id
        // значення що створив раніше в закоментованому коді 23-31, то це буде один обєкт і весь він буде загружений
        // зразу fetch.lazy ігнорується
//        Maid maidTest2 = session.find(Maid.class, 70);

//        Maid maidTest = session.find(Maid.class,70);
        Maid maidTest = (Maid) session.createQuery("SELECT m FROM Maid m LEFT JOIN FETCH m.billingDetails WHERE m.id = :id").
                setParameter("id",70).getSingleResult();

        BillingDetails billingDetails = maidTest.getBillingDetails();

//        Assertions.assertFalse(billingDetails instanceof CreditCard); // через fetch.lazy буде проксі об'єкт а значить немає інформації про точний тип

//        CreditCard creditCard1 = (CreditCard) billingDetails; // по суті те саме що і в коментарі 46 радка, через прокси обєкт буде
//        викликано помилку ClassCastException, для того щоб такого не сталось обєкт потрібно завантажувати не через find, а через Select із використанням
//        JOIN FETCH строки (41-42)

        Assertions.assertTrue(billingDetails instanceof CreditCard);

        CreditCard creditCard1 = (CreditCard) billingDetails;
        // рядки 52 та 54 використовують обєкт загружений за допомогою 41-42 рядка

        // Другим методом миттєвої загрузки може бути
        // CreditCard creditCard1 = session.getReference(CreditCard.class, billingDetails.getId()); //  однак тут буде створено різні проксі
        // класи, но у creditCard1 буде інформація про методи CreditCard

        session.getTransaction().commit();
    }
}
