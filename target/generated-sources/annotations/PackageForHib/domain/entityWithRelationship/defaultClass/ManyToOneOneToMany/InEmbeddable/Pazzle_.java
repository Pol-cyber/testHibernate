package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.InEmbeddable;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pazzle.class)
public abstract class Pazzle_ {

	public static volatile SingularAttribute<Pazzle, String> size;
	public static volatile SetAttribute<Pazzle, RelationForPazzle> relationForPazzleSet;

	public static final String SIZE = "size";
	public static final String RELATION_FOR_PAZZLE_SET = "relationForPazzleSet";

}

