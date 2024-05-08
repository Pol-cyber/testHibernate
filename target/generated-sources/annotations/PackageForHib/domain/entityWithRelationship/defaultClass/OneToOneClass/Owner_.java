package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Owner.class)
public abstract class Owner_ {

	public static volatile SingularAttribute<Owner, Integer> id;
	public static volatile SingularAttribute<Owner, Parrot> parrot;

	public static final String ID = "id";
	public static final String PARROT = "parrot";

}

