package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithMap;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tea.class)
public abstract class Tea_ {

	public static volatile SingularAttribute<Tea, Integer> id;
	public static volatile MapAttribute<Tea, Mug, Spoon> map;

	public static final String ID = "id";
	public static final String MAP = "map";

}

