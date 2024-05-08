package PackageForHib.domain.EntityForTestLazyCollection;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ThirdEntity.class)
public abstract class ThirdEntity_ {

	public static volatile SetAttribute<ThirdEntity, FirstEntity> firstEntity;
	public static volatile SetAttribute<ThirdEntity, SecondEntity> secondEntity;
	public static volatile SingularAttribute<ThirdEntity, Integer> id;

	public static final String FIRST_ENTITY = "firstEntity";
	public static final String SECOND_ENTITY = "secondEntity";
	public static final String ID = "id";

}

