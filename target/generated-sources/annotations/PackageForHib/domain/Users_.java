package PackageForHib.domain;

import PackageForHib.domain.embeddableC.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, Address> address;
	public static volatile SingularAttribute<Users, Long> id;

	public static final String ADDRESS = "address";
	public static final String ID = "id";

}

