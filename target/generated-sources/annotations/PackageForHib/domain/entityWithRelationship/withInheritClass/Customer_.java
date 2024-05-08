package PackageForHib.domain.entityWithRelationship.withInheritClass;

import PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SetAttribute<Customer, BillingDetails> billingDetailsSet;
	public static volatile SingularAttribute<Customer, Integer> id;

	public static final String BILLING_DETAILS_SET = "billingDetailsSet";
	public static final String ID = "id";

}

