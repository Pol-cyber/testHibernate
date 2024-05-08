package PackageForHib.domain;

import PackageForHib.domain.userType.MonetaryAmount;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ForUserType.class)
public abstract class ForUserType_ {

	public static volatile SingularAttribute<ForUserType, MonetaryAmount> monetaryUSD;
	public static volatile SingularAttribute<ForUserType, Integer> id;
	public static volatile SingularAttribute<ForUserType, MonetaryAmount> monetaryEUR;

	public static final String MONETARY_US_D = "monetaryUSD";
	public static final String ID = "id";
	public static final String MONETARY_EU_R = "monetaryEUR";

}

