package PackageForHib.domain.EntityForTestLazyCollection;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FirstEntity.class)
public abstract class FirstEntity_ {

	public static volatile SetAttribute<FirstEntity, SecondEntity> secondEntity;
	public static volatile SingularAttribute<FirstEntity, ThirdEntity> thirdEntity;
	public static volatile SingularAttribute<FirstEntity, Integer> id;
	public static volatile SingularAttribute<FirstEntity, String> text;

	public static final String SECOND_ENTITY = "secondEntity";
	public static final String THIRD_ENTITY = "thirdEntity";
	public static final String ID = "id";
	public static final String TEXT = "text";

}

