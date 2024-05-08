package PackageForHib.domain;

import PackageForHib.domain.userType.MonetaryAmount;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Balance.class)
public abstract class Balance_ {

	public static volatile SingularAttribute<Balance, MonetaryAmount> money;
	public static volatile SingularAttribute<Balance, Long> id;

	public static final String MONEY = "money";
	public static final String ID = "id";

}

