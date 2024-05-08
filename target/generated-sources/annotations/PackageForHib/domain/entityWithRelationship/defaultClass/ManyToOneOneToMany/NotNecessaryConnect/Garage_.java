package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.NotNecessaryConnect;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Garage.class)
public abstract class Garage_ {

	public static volatile SetAttribute<Garage, Motorbike> motorbikes;
	public static volatile SingularAttribute<Garage, Integer> id;

	public static final String MOTORBIKES = "motorbikes";
	public static final String ID = "id";

}

