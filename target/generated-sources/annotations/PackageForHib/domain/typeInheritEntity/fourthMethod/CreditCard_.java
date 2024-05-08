package PackageForHib.domain.typeInheritEntity.fourthMethod;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CreditCard.class)
public abstract class CreditCard_ extends PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails_ {

	public static volatile SingularAttribute<CreditCard, String> expMonth;
	public static volatile SingularAttribute<CreditCard, String> expYear;
	public static volatile SingularAttribute<CreditCard, String> cardNumber;

	public static final String EXP_MONTH = "expMonth";
	public static final String EXP_YEAR = "expYear";
	public static final String CARD_NUMBER = "cardNumber";

}

