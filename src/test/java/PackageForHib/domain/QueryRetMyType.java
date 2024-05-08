package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import PackageForHib.domain.castomReturnObjectInQuery.MyBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRetMyType {


    @Test
    public void retBean(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();


        session.getTransaction().begin();

//        List<MyBean> list = session.createQuery("SELECT new PackageForHib.domain.castomReturnObjectInQuery.MyBean(m.id,m.text) " +
//                "FROM Message m",MyBean.class).getResultList();

//       Другий метод но setResultTransformer позначений як застарілий метод замість нього можна получити List<Object[]>
//       і використати stream().map().collect() для перетворення типу Object[] в MyBean
//        List<MyBean> list = session.createQuery("SELECT m.id AS idMessage,m.text as textMessage " +
//                "FROM Message m").setResultTransformer(new AliasToBeanResultTransformer(MyBean.class)).list();

        try {
            List<MyBean> resultList = session.createNativeQuery("SELECT id, text FROM message").addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("text")
                    .setResultTransformer(new AliasToBeanConstructorResultTransformer(MyBean.class.getConstructor(Long.class, String.class)))
                    .getResultList();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }   // це не стосується цього тесту перевіряв дещо інше

//        list.stream().forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void useResultTransformer(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("SELECT m.id AS idM,m.text AS tM FROM Message m");
        query.setResultTransformer(new ResultTransformer() {
            @Override
            public Object transformTuple(Object[] objects, String[] strings) {
                Map<String,Object> map = new HashMap<>();
                for(int  i = 0; i < objects.length; i++){
                    map.put(strings[i],objects[i]);
                }
                return map;
            }

            @Override
            public List transformList(List list) {
                return list;
            }
        });
        List<Map<String,Object>> list = query.getResultList();
        for(Map<String,Object> o: list){
            for(Map.Entry<String,Object> e: o.entrySet()){
                System.out.println(e.getKey() + "    "+e.getValue());
            }
            System.out.println("____________");
        }

        session.getTransaction().commit();
        session.close();
    }
}
