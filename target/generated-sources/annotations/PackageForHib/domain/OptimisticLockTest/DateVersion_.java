package PackageForHib.domain.OptimisticLockTest;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DateVersion.class)
public abstract class DateVersion_ {

	public static volatile SingularAttribute<DateVersion, String> name;
	public static volatile SingularAttribute<DateVersion, Integer> id;
	public static volatile SingularAttribute<DateVersion, Date> version;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

