package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(People.class)
public abstract class People_ {

	public static volatile SingularAttribute<People, Integer> name;
	public static volatile SingularAttribute<People, Heart> heart;

	public static final String NAME = "name";
	public static final String HEART = "heart";

}

