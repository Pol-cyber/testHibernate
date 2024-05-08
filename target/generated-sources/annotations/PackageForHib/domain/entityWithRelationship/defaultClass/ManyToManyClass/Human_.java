package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Human.class)
public abstract class Human_ {

	public static volatile SingularAttribute<Human, Integer> id;
	public static volatile SetAttribute<Human, Animal> animals;

	public static final String ID = "id";
	public static final String ANIMALS = "animals";

}

