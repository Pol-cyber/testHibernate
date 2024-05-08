package PackageForHib.domain.typeInheritEntity.firstMethod;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, Date> date;
	public static volatile SingularAttribute<Animal, String> name;

	public static final String DATE = "date";
	public static final String NAME = "name";

}

