package PackageForHib.domain;

import PackageForHib.domain.EntityForTestLazyCollection.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityGraph;
import javax.persistence.Subgraph;
import javax.persistence.metamodel.SetAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Проблема всіх цих методів в тому що коли я запускаю вони завантажують зразу все (тобто точно так само як і при дебагу, кожен Lazy буде завантажено зразу)
// Всі тести працюють просто необхідно використати не в тестах, а в звичайному коді - інакше не побачим різниці
public class TestEntityGraph {
    @Test
    public void testCrossAnnotation(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Map<String,Object> properties = new HashMap<>();
        properties.put("javax.persistence.loadgraph",session.getEntityGraph(ThirdEntity.NAMED_ENTITY_GRAPH_FIRSTENTITY));
        ThirdEntity thirdEntity = session.find(ThirdEntity.class,198);
        session.detach(thirdEntity);
        System.out.println("---------------------------------------------------");
        thirdEntity = session.find(ThirdEntity.class,198,properties); // за допомогою анотації об'явленої перед класом
        session.getTransaction().commit();
    }

    @Test
    public void testCrossOwnGeneration(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        session.getTransaction().begin();
        Map<String,Object> properties = new HashMap<>();

        EntityGraph<ThirdEntity> thirdEntityEntityGraph = session.createEntityGraph(ThirdEntity.class);
        thirdEntityEntityGraph.addAttributeNodes(ThirdEntity_.firstEntity);
        properties.put("javax.persistence.loadgraph",thirdEntityEntityGraph); // за допомогою ручного створення графу
        ThirdEntity thirdEntity = session.find(ThirdEntity.class,198);
        session.detach(thirdEntity);
        System.out.println("---------------------------------------------------");
        thirdEntity = session.find(ThirdEntity.class,198,properties); // за допомогою ручного створення графу
        session.getTransaction().commit();
    }

    @Test
    public void testCrossAnnotationWithSub(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Map<String,Object> properties = new HashMap<>();
        properties.put("javax.persistence.loadgraph",session.getEntityGraph(ThirdEntity.NAMED_ENTITY_GRAPH_FIRSTENTITY_WITH_SUB));
        ThirdEntity thirdEntity = session.find(ThirdEntity.class,198);
        session.detach(thirdEntity);
        System.out.println("---------------------------------------------------");
        thirdEntity = session.find(ThirdEntity.class,198,properties); // за допомогою анотації об'явленої перед класом
        session.getTransaction().commit();
    }

    @Test
    public void testCrossOwnGenerationWithSub(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        session.getTransaction().begin();
        Map<String,Object> properties = new HashMap<>();

        EntityGraph<ThirdEntity> thirdEntityEntityGraph = session.createEntityGraph(ThirdEntity.class);
        thirdEntityEntityGraph.addAttributeNodes(ThirdEntity_.firstEntity);
        Subgraph<Set<FirstEntity>> secondEntitySubgraph = thirdEntityEntityGraph.addSubgraph(ThirdEntity_.firstEntity);
        secondEntitySubgraph.addAttributeNodes(new SetAttribute[]{FirstEntity_.secondEntity});
        properties.put("javax.persistence.loadgraph",thirdEntityEntityGraph); // за допомогою ручного створення графу
        ThirdEntity thirdEntity = session.find(ThirdEntity.class,198);
        session.detach(thirdEntity);
        System.out.println("---------------------------------------------------");
        thirdEntity = session.find(ThirdEntity.class,198,properties); // за допомогою ручного створення графу
        session.getTransaction().commit();
    }
}
