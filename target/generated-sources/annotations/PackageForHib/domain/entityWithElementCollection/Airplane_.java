package PackageForHib.domain.entityWithElementCollection;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Airplane.class)
public abstract class Airplane_ {

	public static volatile SingularAttribute<Airplane, Integer> id;
	public static volatile CollectionAttribute<Airplane, String> collection;

	public static final String ID = "id";
	public static final String COLLECTION = "collection";

}

