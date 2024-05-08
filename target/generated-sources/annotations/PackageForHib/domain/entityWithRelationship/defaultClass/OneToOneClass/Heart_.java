package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Heart.class)
public abstract class Heart_ {

	public static volatile SingularAttribute<Heart, Integer> id;
	public static volatile SingularAttribute<Heart, People> people;

	public static final String ID = "id";
	public static final String PEOPLE = "people";

}

