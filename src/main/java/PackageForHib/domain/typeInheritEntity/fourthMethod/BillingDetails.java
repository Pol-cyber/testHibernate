package PackageForHib.domain.typeInheritEntity.fourthMethod;




import PackageForHib.domain.entityWithRelationship.withInheritClass.Customer;

import javax.persistence.*;

// оскільки тут тип наслідування joined то даний обєкт буде створений в любому випадку як таблиця  в БД
// (забрав abstract через те що хотів спробувати роботу
//        Query query = session.createQuery("SELECT o FROM java.lang.Object o");
//        System.out.println(query.getResultList()); детальніше TestQuery)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetails {

    @Id
    @GeneratedValue
    protected long id;

    @ManyToOne
    protected Customer customer;// Дане поле не стосується методу наслудування, а просто для перевірки асоціації поліморфних свойств (не знаю чи правильно назвав)


}
