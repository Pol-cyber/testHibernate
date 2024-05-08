package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, Integer> id;
	public static volatile SetAttribute<Animal, Human> humans;

	public static final String ID = "id";
	public static final String HUMANS = "humans";

}

