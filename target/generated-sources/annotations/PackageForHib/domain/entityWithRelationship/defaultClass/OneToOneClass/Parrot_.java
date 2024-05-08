package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Parrot.class)
public abstract class Parrot_ {

	public static volatile SingularAttribute<Parrot, Owner> owner;
	public static volatile SingularAttribute<Parrot, Integer> id;

	public static final String OWNER = "owner";
	public static final String ID = "id";

}

