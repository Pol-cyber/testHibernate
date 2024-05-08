package PackageForHib.domain.typeInheritEntity.fourthMethod;

import PackageForHib.domain.entityWithRelationship.withInheritClass.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BillingDetails.class)
public abstract class BillingDetails_ {

	public static volatile SingularAttribute<BillingDetails, Long> id;
	public static volatile SingularAttribute<BillingDetails, Customer> customer;

	public static final String ID = "id";
	public static final String CUSTOMER = "customer";

}

