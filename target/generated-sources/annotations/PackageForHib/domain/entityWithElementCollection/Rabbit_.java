package PackageForHib.domain.entityWithElementCollection;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rabbit.class)
public abstract class Rabbit_ {

	public static volatile SetAttribute<Rabbit, String> carrots;
	public static volatile SingularAttribute<Rabbit, Long> id;

	public static final String CARROTS = "carrots";
	public static final String ID = "id";

}

