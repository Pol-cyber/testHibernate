package PackageForHib.domain.typeInheritEntity.fourthMethod;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BankAccount.class)
public abstract class BankAccount_ extends PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails_ {

	public static volatile SingularAttribute<BankAccount, String> bankname;
	public static volatile SingularAttribute<BankAccount, String> account;
	public static volatile SingularAttribute<BankAccount, String> swift;

	public static final String BANKNAME = "bankname";
	public static final String ACCOUNT = "account";
	public static final String SWIFT = "swift";

}

