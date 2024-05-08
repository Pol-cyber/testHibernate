package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContainerParent.class)
public abstract class ContainerParent_ {

	public static volatile SingularAttribute<ContainerParent, Integer> id;
	public static volatile CollectionAttribute<ContainerParent, ContainerChild> collection;

	public static final String ID = "id";
	public static final String COLLECTION = "collection";

}

