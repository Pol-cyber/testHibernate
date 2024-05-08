package PackageForHib.domain;

import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.PersistenceUtil;
import javax.sound.sampled.ReverbType;
import java.util.Date;
import java.util.List;

public class TestHibernateEnvers {

    @Test
    public void auditByHand() {
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();
        AuditReader audioReader = AuditReaderFactory.get(session);
        Number number = audioReader.getRevisionNumberForDate(new Date());
        System.out.println(number);

        List<Number> numbers = audioReader.getRevisions(Message.class, 533L);
        Assertions.assertEquals(4,numbers.size());
        for (Number n : numbers) {
            Date date = audioReader.getRevisionDate(n);
            System.out.println(date);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testAuditQuery(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        AuditReader auditReader = AuditReaderFactory.get(session);

        AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Message.class,false,false);

        List<Object[]> list = auditQuery.getResultList();

        for(Object[] o : list){
            Message m  = (Message) o[0];
            DefaultRevisionEntity defaultRevisionEntity = (DefaultRevisionEntity) o[1];
            RevisionType reverbType = (RevisionType) o[2];
            System.out.println(m);
            System.out.println(defaultRevisionEntity.getId());
            System.out.println(reverbType.getRepresentation());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void archiveData(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        AuditReader auditReader = AuditReaderFactory.get(session);

        Message message = auditReader.find(Message.class,533L,215);

        Assertions.assertEquals("tdff",message.getText());

        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void enversCriteria(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        AuditReader auditReader = AuditReaderFactory.get(session);

        AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Message.class,false,false);

        auditQuery.add(AuditEntity.property(Message_.TEXT).like("Nn%"));
        auditQuery.add(AuditEntity.property(Message_.TEXT).isNotNull());

        List<Object[]> list = auditQuery.getResultList();

        for(Object[] o : list){
            Message m  = (Message) o[0];
            DefaultRevisionEntity defaultRevisionEntity = (DefaultRevisionEntity) o[1];
            RevisionType reverbType = (RevisionType) o[2];
            System.out.println(m);
            System.out.println(defaultRevisionEntity.getId());
            System.out.println(reverbType.getRepresentation());
        }

        AuditQuery auditQuery1 = auditReader.createQuery().forEntitiesAtRevision(Message.class,214);

        auditQuery1.addProjection(AuditEntity.property(Message_.TEXT));

        String t = (String) auditQuery1.getSingleResult();
        Assertions.assertEquals("Nnn text",t);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void  backtoOldVersion(){
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

        AuditReader auditReader = AuditReaderFactory.get(session);

        Message message  = auditReader.find(Message.class,533L,214);
//        System.out.println(session.contains(message));
//        PersistenceUnitUtil persistenceUnit = session.getEntityManagerFactory().getPersistenceUnitUtil();
//        System.out.println(persistenceUnit.getIdentifier(message));
//        session.merge(message);

        session.getTransaction().commit();
        session.close();
    }
}
