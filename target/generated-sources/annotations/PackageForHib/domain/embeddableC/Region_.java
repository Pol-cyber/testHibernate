package PackageForHib.domain.embeddableC;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Region.class)
public abstract class Region_ {

	public static volatile SingularAttribute<Region, String> country;
	public static volatile SingularAttribute<Region, Integer> countPeople;

	public static final String COUNTRY = "country";
	public static final String COUNT_PEOPLE = "countPeople";

}

