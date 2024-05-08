package PackageForHib.manager;

import PackageForHib.domain.*;
import PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit.ClassForInterceptor;
import PackageForHib.domain.OptimisticLockTest.LongVersion;
import PackageForHib.domain.entityUseUserDomain.TestDomainEmailAddress;
import org.hibernate.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.QueryHints;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.jpa.HibernateQuery;
import org.hibernate.jpamodelgen.xml.jaxb.NamedEntityGraph;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.sound.sampled.spi.AudioFileReader;
import java.util.*;
import org.hibernate.event.spi.EventType; // можно посмотреть все дефолтные приемники
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.hibernate.service.spi.InjectService;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;




public class ManegerSession {
    static class ProductList extends ArrayList<Message> {

        public List<String> listName() {
            List<String> names = new ArrayList<>();
            for (Message product : this) {
                names.add(product.getText());
            }
            return names;
        }
    }

    static class Pa<T>{
    }

    static public <T> Pa<T> method(String s) {
        return new Pa<T>();
    }  // код що знаходиться тут я використовував для перевірки обощений це не повязано з Hibernate
    // було інтересно як працює Path<Integer> p = Root#get("column");


    public static void main(String[] args) throws NoSuchFieldException {
        SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new ClassForInterceptor()).openSession();

        session.getTransaction().begin();

//        Message m  = new Message();
//
//        session.persist(m);

        Message m = session.find(Message.class,20L);

        Statistics s = sessionFactory.getStatistics();

        EntityStatistics entityStatistics = s.getEntityStatistics("PackageForHib.domain.Message");
        long elementCountInMemory = entityStatistics.getCachePutCount();
        System.out.println("Element count in memory: " + elementCountInMemory);


//        SecondLevelCacheStatistics secondLevelCacheStatistics = s.getSecondLevelCacheStatistics(Message.class.getName());
//
//        System.out.printf(secondLevelCacheStatistics.getElementCountInMemory() + "   -----------\n"+Message.class.getName()+"\n");
//


//        TestDomainEmailAddress  c = new TestDomainEmailAddress();
//
//        c.setEmails("Hello@gmail.com");
//        c.setEmails2("admin@gmail.com");
//        session.persist(c);

        session.getTransaction().commit();
        session.close();

        Session s1 = sessionFactory.openSession();

        s1.getTransaction().begin();


        Message m1 = s1.find(Message.class,20L);


        s1.getTransaction().commit();
        s1.close();




//        EntityForMyFindLoader e = session.find(EntityForMyFindLoader.class,123);

//        org.hibernate.procedure.ProcedureCall call =
//                session.createStoredProcedureCall("testfunc", Message.class);
////        call.registerParameter(1,void.class,ParameterMode.REF_CURSOR);
//        org.hibernate.result.ResultSetOutput resultSetOutput =
//                (org.hibernate.result.ResultSetOutput) call.getOutputs().getCurrent();
//        List<Message> result = resultSetOutput.getResultList();
//
//        System.out.println("");
//        Host host = session.find(Host.class,121);
//        System.out.println("________________________________________");

//        EntityForMyFindLoader entity = session.find(EntityForMyFindLoader.class,123);
//
//        System.out.println(entity);

//        Message m = session.find(Message.class,437L);
//        m.setText("ggs");

//        List<Object[]> objects = session.createNamedQuery("ReurnAllEmployeeTree").getResultList();
//
//        System.out.println("HH");

//        Host h = session.find(Host.class,127);
//
//        Player p = session.find(Player.class,129);
//        Player pd = session.find(Player.class,128);
//        System.out.println("---------------");
//        h.getPlayerSet().iterator().next();



//        Query m = session.createNativeQuery("SELECT id,'Action: ' || text AS TextNew FROM Message m WHERE m.id = ?","MessageResult");
////        Query m = session.createNativeQuery("SELECT id,'Action: ' || text AS TextNew FROM Message m WHERE m.id = ?","ExternalizedMessageResult");
////        Query m = session.createNativeQuery("SELECT m.id,m.text FROM Message m WHERE m.id = ?",Message.class);
//        m.setParameter(1,437L);
//        Message me = (Message) m.getSingleResult();
//        System.out.println(me);
//        DetachedCriteria d = DetachedCriteria.forClass(Message.class);
//        d.getExecutableCriteria(session).list();

//        Host h = session.find(Host.class,121);
//        Query query = session.createQuery("SELECT h FROM Host h JOIN h.playerSet p WHERE p.host = :id_h");
//        query.setParameter("id_h",h);
//        Query query = (Query) session.createFilter(h.getPlayerSet(),"");
//        query.setFirstResult(0);
//        query.setMaxResults(2);
//        List<Host> l  = query.getResultList();
//        System.out.println("");


//        List<Object[]> list = query.getResultList();
//        for(Object[] o : list){
//            for(Object ob : o){
//                System.out.println(ob);
//            }
//            System.out.println("____________");
//        }
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//        Root<Host> hostRoot = criteriaQuery.from(Host.class);
//        Join<Host,Player> playerJoin = hostRoot.join("playerSet");
//        playerJoin.on(criteriaBuilder.equal(hostRoot.get(Host_.ID),playerJoin.get(Player_.HOST)));
//
//        List<Host> list = session.createQuery(criteriaQuery.select(hostRoot)).setMaxResults(3).getResultList();
//        System.out.println();





//        Query<Message> q = session.createQuery("SELECT m FROM Message m");
//        sessionFactory.addNamedQuery("checkQ",q);
//
//        session.getTransaction().begin();
//
//        List<Object[]> tuples = session.createQuery("SELECT p.id,p.host.text FROM Player p ").getResultList();
//
//        for (Object[] p:
//             tuples) {
//            System.out.println(p[0]);
//            System.out.println(p[1]);
//            System.out.println("------------------------");
//        }

//        List<Object[]> list  = session.createQuery("SELECT m,c FROM Message m,Cat c").getResultList();
//        System.out.println("");
//        System.out.println(session.createQuery("SELECT c FROM Cat c WHERE c.dateBorn = '2023-03-25 15:27:02.109000'").getResultList());


//        System.out.println(session.createQuery("SELECT f FROM Fruit f").getResultList());


//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
//        Root<Message> messageRoot = criteriaQuery.from(Message.class);
//        criteriaQuery.where(criteriaBuilder.equal(messageRoot.get(Message_.TEXT),"gssss"));
//        System.out.println(session.createQuery(criteriaQuery).getResultList());

//        Query<Message> query = session.createQuery("SELECT m FROM Message m",Message.class).setHint(QueryHints.READ_ONLY,true);
//
//        List<Message> m = query.getResultList();
//        for(int i = 0; i < 4; i++){
//            m.get(i).setText(i+" new");
//        }
//
//        session.setReadOnly(m.get(3),false);
//        List<Message> m  = session.createQuery("SELECT m.text FROM Message m").getResultList();
//        Query<Message> query = session.createQuery("SELECT m.text FROM Message m");
//        Iterator<Message> s = query.iterate();
//        while (s.hasNext()){
//            System.out.println(s.next());
//        }
//        Hibernate.close(s); // в любому випадку закриється після виклику session.close()
//        System.out.println(m);
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Message> messageCriteriaQuery = criteriaBuilder.createQuery(Message.class);
//        Root<Message> messageRoot = messageCriteriaQuery.from(Message.class);
//        messageCriteriaQuery.select(messageRoot).where(criteriaBuilder.equal(messageRoot.get(Message_.text),criteriaBuilder.
//                parameter(String.class,"paramtext")));
//        System.out.println(session.createQuery(messageCriteriaQuery).setParameter("paramtext","gssss").getResultList());
//        Query query = session.createQuery(
//                "select i from Message i WHERE i.text = :id"
//        );
//        for (Parameter<?> parameter : query.getParameters()) {
//            System.out.println(parameter.getParameterType());
//        }
//        Filter filter = session.enableFilter("text_filter");
//        filter.setParameter("textpar","YES");
//        Area area = session.find(Area.class,221);
//        System.out.println(area.getTreeCSet());
//        Area area = new Area();
//        TreeC treeC = new TreeC();
//        TreeC treeC1 = new TreeC();
//        TreeC treeC2 = new TreeC();
//        treeC.setText("F");
//        treeC.setArea(area);
//        treeC1.setText("a");
//        treeC1.setArea(area);
//        treeC2.setText("b");
//        treeC2.setArea(area);
//        session.persist(area);
//        session.persist(treeC);
//        session.persist(treeC1);
//        session.persist(treeC2);
//        Message m = new Message();
//        m.setId(533L);
//        m.setText("HHHh");
//        session.merge(m);
//        Message message = session.find(Message.class,533L);
//        message.setText("tdff");

//        EntityForListener entitityFirstListener = new EntityForListener();
//        session.persist(entitityFirstListener);
//        EntityForListener entityForListener = session.find(EntityForListener.class,210);
//        FirstForCascade firstForCascade = session.getReference(FirstForCascade.class,206);
//        System.out.println(firstForCascade);
//        session.detach(firstForCascade);
//        FirstForCascade f = (FirstForCascade) session.merge(firstForCascade);
//        System.out.println(f);
//        FirstForCascade firstForCascade = new FirstForCascade();
//        session.merge(firstForCascade);
//        System.out.println(firstForCascade.getId());
//        FirstForCascade firstForCascade = session.find(FirstForCascade.class,206);
//        firstForCascade.getSecondForCascadeSet().size();
//        session.detach(firstForCascade);
//        firstForCascade.addElement(new SecondForCascade(firstForCascade));
//        firstForCascade.setText("New Text");
//        session.merge(firstForCascade);
//
//        for(SecondForCascade s : firstForCascade.getSecondForCascadeSet()){
//            System.out.println(s.getId());
//        }
//        FirstForCascade firstForCascade = new FirstForCascade();
//        SecondForCascade secondForCascade = new SecondForCascade();
//        session.persist(firstForCascade);
//        secondForCascade.setFirstForCascade(firstForCascade);
//        session.persist(secondForCascade);
//        FirstEntity f = new FirstEntity();
//        System.out.println(f.getId());
//        FirstEntity firstEntity  = session.find(FirstEntity.class,199);
//        session.detach(firstEntity);
//        firstEntity.setText("NEW TEXT");
//        System.out.println("---------------------------");
//        session.merge(firstEntity);
//        session.detach(secondEntity);
//        session.merge(secondEntity);
//        System.out.println(secondEntity.getFirstEntity());
//        session.detach(secondEntity);
//        secondEntity.getFirstEntity().getText();
//        FirstEntity firstEntity = secondEntity.getFirstEntity();
//        System.out.println(firstEntity.getText());
//        firstEntity.setText("DDDD");
//        session.merge(firstEntity);
//        FirstEntity firstEntity = new FirstEntity();
//        firstEntity.setText("GGGGG");
//        session.persist(firstEntity);
//        secondEntity.setFirstEntity(firstEntity);

//        ThirdEntity thirdEntity = session.find(ThirdEntity.class,198);
//        System.out.println("КІНЕЦ");
//        session.detach(thirdEntity);
//        session.enableFetchProfile(ThirdEntity.FETCH_PROFILE_FIRSTENTITY);
//        session.enableFetchProfile(ThirdEntity.FETCH_PROFILE_SECONDENTITY);
//        thirdEntity = session.find(ThirdEntity.class,198);
//        SecondEntity secondEntity = new SecondEntity();
//        session.persist(secondEntity);
//        FirstEntity firstEntity = new FirstEntity();
//        session.persist(firstEntity);
//        ThirdEntity thirdEntity  = new ThirdEntity();
//        thirdEntity.addSecondEntity(secondEntity);
//        thirdEntity.addFirstEntity(firstEntity);
//        session.persist(thirdEntity);

//        FirstEntity firstEntity = session.find(FirstEntity.class,185);
//        System.out.println(firstEntity.getSecondEntity().size());
//        session.detach(firstEntity);
//        System.out.println(firstEntity.getSecondEntity().size());
//        FirstEntity firstEntity = session.find(FirstEntity.class,185);
//        Set<SecondEntity> secondEntities = firstEntity.getSecondEntity();
//
//        System.out.println(Hibernate.isInitialized(secondEntities));
//        System.out.println(secondEntities.size());
//        System.out.println(Hibernate.isInitialized(secondEntities));

//        FirstEntity firstEntity = new FirstEntity();
//        session.persist(firstEntity);
//        for(int  i = 0 ; i < 5; i++){
//            SecondEntity secondEntity = new SecondEntity();
//            secondEntity.setFirstEntity(firstEntity);
//            session.persist(secondEntity);
//        }
//        Message message = session.find(Message.class,373L);
//        System.out.println(message.getDescription());

//        Message m = session.getReference(Message.class,21L);
//
//        System.out.println(Hibernate.isInitialized(m));
//        m.getId();
//        System.out.println(Hibernate.isInitialized(m));
//        System.out.println(m.getText());
//        LongVersion l = session.find(LongVersion.class,181, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
//        System.out.println(l.getVersion());
//        DateVersion dateVersion = session.find(DateVersion.class,182);
//        dateVersion.setName("NewVersion");
//        DateVersion dateVersion = new DateVersion();
//        session.persist(dateVersion);
//        LongVersion l = session.find(LongVersion.class,181);
//        l.setName("Hello");
//        LongVersion longVersion = new LongVersion();
//        session.persist(longVersion);
//
//
//        Message message = new Message("SD");
//
//        session.persist(message);
//
//        Message message = session.find(Message.class,21L);
//        message.setText("dsaxz");
//        session.flush();

//        session.detach(message);


//        session.setHibernateFlushMode(FlushMode.COMMIT);

//        String m = (String) session.createQuery("select m.text from Message m where m.id = :id")
//                .setParameter("id", 21L).getSingleResult();

//        System.out.println(m);




//        Query query = session.createQuery("SELECT m FROM Message m");
//
//        List<Message> l1 = query.setReadOnly(true).list();
//
//        List<Message> l2 = query.list();
//
//        System.out.println(l1 +"\n"+l2);
//
//        for (Message item : l2)
//            item.setText("New Name");
//        session.flush();


//        Message message = session.find(Message.class,21L);
//        session.remove(message);
//        System.out.println();


//        Message message = session.getReference(Message.class,21L);
//        System.out.println(message);
//        Message m = new Message("ssdasd");
//        session.persist(m);
//        System.out.println("F");

//        Product product = session.find(Product.class,172);

//        List<Shop> shops = session.createQuery("SELECT s FROM Shop s JOIN s.set ss WHERE ss.product = :product").
//                setParameter("product",product).getResultList();
//
//        System.out.println(shops);

//        Bayer bayer = new Bayer();
//        Product product  = new Product();
//        Product product1 = new Product();
//
//        session.persist(bayer);
//        session.persist(product);
//        session.persist(product1);
//
//        EmbeddableLinkForShopAndProd embeddableLinkForShopAndProd = new EmbeddableLinkForShopAndProd(product,bayer,"H");
//        EmbeddableLinkForShopAndProd embeddableLinkForShopAndProd1 = new EmbeddableLinkForShopAndProd(product1,null,"D");
//
//        Shop shop = new Shop();
//        shop.addElement(embeddableLinkForShopAndProd);
//        shop.addElement(embeddableLinkForShopAndProd1);
//
//        session.persist(shop);


//        Student student = new Student();
//        Course course = new Course();
//
//        session.persist(student);
//        session.persist(course);
//
//        LinkTableForSTAndCO linkTableForSTAndCO = new LinkTableForSTAndCO(course,student,"CheckInsert");
//        session.persist(linkTableForSTAndCO);


//        ListParent listParent = new ListParent();
//        ListChild listChild = new ListChild();
//        listChild.setListParent(listParent);
//        session.persist(listChild);
//
//        listParent.addElement(listChild);
//
//        ListChild listChild1 = new ListChild();
//        listChild1.setListParent(listParent);
//        session.persist(listChild1);
//
//        listParent.addElement(listChild1);
//
//        session.persist(listParent);


//        Owner owner = session.find(Owner.class, 143);
//        Owner owner1 = session.find(Owner.class, 144);
//        System.out.println();

//        Owner owner =new Owner();
//        session.persist(owner);
//        session.persist(owner);

//        Tree tree = new Tree();
//        session.persist(tree);
//
//        Owner owner = new Owner();
//        session.persist(owner);
//
//        Tree tree1 = new Tree();
//        tree1.setOwner(owner);
//        session.persist(tree1);

//        Owner owner = new Owner();
//
//        Parrot parrot = new Parrot(owner);
//        owner.setParrot(parrot);
//
//        session.persist(owner);



//        Airplane airplane = session.find(Airplane.class,139);
//
//        session.remove(airplane);

//        Airplane airplane = new Airplane();
//        airplane.addElement("Hello");
//        airplane.addElement("Hello1");

//        session.persist(airplane);


//        Host h = session.find(Host.class,121);
//
////        h.getPlayerSet().remove(h.getPlayerSet().iterator().next());
//
//        System.out.println(h.getPlayerSet());

//        Host host = new Host();
//        session.persist(host);
//        Player player = new Player(host);
//        host.addElement(player); //  підтримує цілісність даних
////        session.persist(player); // не потрібно якщо оголошено CascadeType.PERSIST
//        Player player1 = new Player(host);
//        host.addElement(player1); //  підтримує цілісність даних
//        session.persist(player1); // не потрібно якщо оголошено CascadeType.PERSIST

//        session.getTransaction().commit();
//        session.close();
//
//        Session s = sessionFactory.openSession();
//        s.getTransaction().begin();
//
//        longVersion = (LongVersion) s.merge(longVersion);
//
//        longVersion.setName("NewName");

//        s.lock(longVersion,LockMode.OPTIMISTIC_FORCE_INCREMENT);

//        s.getTransaction().commit();
//        s.close();
    }
}
