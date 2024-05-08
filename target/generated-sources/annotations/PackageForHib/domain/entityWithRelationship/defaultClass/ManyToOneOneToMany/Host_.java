package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Host.class)
public abstract class Host_ {

	public static volatile SingularAttribute<Host, Integer> id;
	public static volatile SingularAttribute<Host, String> text;
	public static volatile SetAttribute<Host, Player> playerSet;

	public static final String ID = "id";
	public static final String TEXT = "text";
	public static final String PLAYER_SET = "playerSet";

}

