package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ListParent.class)
public abstract class ListParent_ {

	public static volatile SingularAttribute<ListParent, Integer> id;
	public static volatile ListAttribute<ListParent, ListChild> list;

	public static final String ID = "id";
	public static final String LIST = "list";

}

