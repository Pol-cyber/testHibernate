package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import PackageForHib.domain.typeInheritEntity.fourthMethod.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.validator.internal.util.logging.Messages_$bundle;
import org.junit.jupiter.api.Test;

import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQuery {

    // Тут я отримую Query за допомогою CriteriaQuery, а іменно викорисовую запит з параметром
    @Test
    public void sessionQueryWithParameter(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").
                build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        Root<Message> messageRoot =  criteriaQuery.from(Message.class);
//        criteriaQuery.select(messageRoot).where(criteriaBuilder.like(messageRoot.get("text"), criteriaBuilder.parameter(String.class,"param")));
        criteriaQuery.select(messageRoot).where(criteriaBuilder.like(messageRoot.get(Message_.text), criteriaBuilder.parameter(String.class,"param")));
        System.out.println(session.createQuery(criteriaQuery).setParameter("param","%ll%").getResultList());
        session.getTransaction().commit();
    }


    //  Класс, указанный в предложении FROM, не обязан быть отображаемым храни-
//мым классом; подойдет любой класс. Следующий запрос возвращает все сохра-
//ненные объекты:
//select o from java.lang.Object o
// Да, вы можете выбрать записи из всех таблиц базы данных и загрузить их в па-
//мять! Это работает и с интерфейсами – можно, к примеру, выбрать все сериали-
//зуемые экземпляры:
//select s from java.io.Serializable s
//Плохая новость в том, что JPA не стандартизует полиморфных запросов JPQL
//с использованием интерфейсов. Они работают только в Hibernate, но переноси-
//мое приложение должно ссылаться в предложении FROM лишь на отображаемые
//классы сущностей, такие как BillingDetails или CreditCard.
// Метод from() из API
//запросов на основе критериев принимает только типы отображаемых сущностей.
//        Query query = session.createQuery("SELECT o FROM java.lang.Object o");
//        System.out.println(query.getResultList());
    @Test
    public void testQueryObject(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();



        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("SELECT o FROM java.lang.Object o");

        System.out.println(query.getResultList());


        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void selectSomeInherit(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();



        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("SELECT o FROM BillingDetails o WHERE type(o) IN :type");
        List<Class> classes = new ArrayList<>();
        classes.add(CreditCard.class);
        System.out.println(query.setParameter("type",classes).getResultList());  // даний варінт з type не може використовуватись із
//         SELECT o FROM java.lang.Object o, оскільки це функціонал Hibernate, а функція TYPE доступна лише у JPA JPQL

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//        Root<BillingDetails> billingDetailsRoot = criteriaQuery.from(BillingDetails.class);
//        criteriaQuery.select(billingDetailsRoot).where(billingDetailsRoot.type().in(Arrays.asList(CreditCard.class)));
//        System.out.println(session.createQuery(criteriaQuery).getResultList());


        session.getTransaction().commit();
        session.close();
    }
}
