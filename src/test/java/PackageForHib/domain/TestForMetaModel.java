package PackageForHib.domain;

import PackageForHib.domain.typeInheritEntity.firstMethod.Dog_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestForMetaModel {


    @Test
    public void testMetaModelForSession(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Metamodel metamodel = session.getMetamodel();
        LinkedHashSet<Object> objects = new LinkedHashSet<Object>();
        Set<ManagedType<?>> set = metamodel.getManagedTypes();
        set.forEach(System.out::println);
        ManagedType<?> managedType = set.iterator().next();
        SingularAttribute singularAttribute = managedType.getSingularAttribute(Dog_.NAME);
        System.out.println(singularAttribute.getType());
        System.out.println(singularAttribute.getJavaType());
        System.out.println(singularAttribute.isOptional());
        System.out.println(singularAttribute.getName());
        System.out.println(singularAttribute.isCollection());


        session.getTransaction().commit();


    }


    @Test
    public void testMetaModel(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Message");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Metamodel metamodel = entityManager.getMetamodel();
        Set<ManagedType<?>> set = metamodel.getManagedTypes();

        set.forEach(System.out::println);
    }
}
