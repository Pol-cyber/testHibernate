package PackageForHib.domain.OptimisticLockTest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LongVersion.class)
public abstract class LongVersion_ {

	public static volatile SingularAttribute<LongVersion, String> name;
	public static volatile SingularAttribute<LongVersion, Integer> id;
	public static volatile SingularAttribute<LongVersion, Long> version;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

