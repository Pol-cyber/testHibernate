package PackageForHib.domain;

import PackageForHib.domain.myEnum.AgeCat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cat.class)
public abstract class Cat_ {

	public static volatile SingularAttribute<Cat, Long> teilLenght;
	public static volatile SingularAttribute<Cat, Date> dateBorn;
	public static volatile SingularAttribute<Cat, AgeCat> ageCat;
	public static volatile SingularAttribute<Cat, String> name;
	public static volatile SingularAttribute<Cat, Long> id;

	public static final String TEIL_LENGHT = "teilLenght";
	public static final String DATE_BORN = "dateBorn";
	public static final String AGE_CAT = "ageCat";
	public static final String NAME = "name";
	public static final String ID = "id";

}

