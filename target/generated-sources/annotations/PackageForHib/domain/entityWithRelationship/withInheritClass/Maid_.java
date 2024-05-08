package PackageForHib.domain.entityWithRelationship.withInheritClass;

import PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Maid.class)
public abstract class Maid_ {

	public static volatile SingularAttribute<Maid, BillingDetails> billingDetails;
	public static volatile SingularAttribute<Maid, Integer> id;

	public static final String BILLING_DETAILS = "billingDetails";
	public static final String ID = "id";

}

