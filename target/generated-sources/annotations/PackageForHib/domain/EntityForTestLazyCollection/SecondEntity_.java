package PackageForHib.domain.EntityForTestLazyCollection;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SecondEntity.class)
public abstract class SecondEntity_ {

	public static volatile SingularAttribute<SecondEntity, FirstEntity> firstEntity;
	public static volatile SingularAttribute<SecondEntity, ThirdEntity> thirdEntity;
	public static volatile SingularAttribute<SecondEntity, Integer> id;

	public static final String FIRST_ENTITY = "firstEntity";
	public static final String THIRD_ENTITY = "thirdEntity";
	public static final String ID = "id";

}

