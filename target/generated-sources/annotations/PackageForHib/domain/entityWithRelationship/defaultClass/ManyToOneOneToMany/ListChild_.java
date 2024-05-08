package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ListChild.class)
public abstract class ListChild_ {

	public static volatile SingularAttribute<ListChild, Integer> id;
	public static volatile SingularAttribute<ListChild, ListParent> listParent;

	public static final String ID = "id";
	public static final String LIST_PARENT = "listParent";

}

