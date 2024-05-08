package PackageForHib.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, String> password;
	public static volatile SingularAttribute<Login, Date> loginDate;
	public static volatile SingularAttribute<Login, Integer> id;

	public static final String PASSWORD = "password";
	public static final String LOGIN_DATE = "loginDate";
	public static final String ID = "id";

}

