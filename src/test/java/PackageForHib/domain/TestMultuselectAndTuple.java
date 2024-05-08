package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Subquery;
import java.util.List;

public class TestMultuselectAndTuple {

    @Test
    public void testTuple(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();
        session.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery  = criteriaBuilder.createTupleQuery();
        criteriaQuery.multiselect(criteriaQuery.from(Message.class).alias("m"),criteriaQuery.from(Cat.class).alias("c"));
        TypedQuery<Tuple> tupleTypedQuery = session.createQuery(criteriaQuery);
//        за допомогою  звичайного JPQL запиту
//        TypedQuery<Tuple> tupleTypedQuery = session.createQuery("SELECT m as ma,c as ca FROM Message m, Cat c", Tuple.class);
        List<Tuple> tuples = tupleTypedQuery.getResultList();

        for(Tuple t : tuples){
            System.out.println(t.get(0,Message.class));
            System.out.println(t.get(1,Cat.class));

            System.out.println(t.get("m",Message.class));
            System.out.println(t.get("c",Cat.class));

//            Для використання за допомогою звичайного JPQL запиту
//            System.out.println(t.get("ma",Message.class));
//            System.out.println(t.get("ca",Cat.class));

            for(TupleElement<?> te:t.getElements()){
                System.out.println(te.getAlias());
                System.out.println(te.getJavaType());
                System.out.println(t.get(te));

            }

            System.out.println("------------------------------------------------");

        }


        session.getTransaction().commit();
        session.close();
    }
}
