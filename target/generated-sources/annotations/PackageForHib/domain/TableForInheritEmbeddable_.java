package PackageForHib.domain;

import PackageForHib.domain.typeInheritEntity.InheritEmbeddable.Dimensions;
import PackageForHib.domain.typeInheritEntity.InheritEmbeddable.Weight;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TableForInheritEmbeddable.class)
public abstract class TableForInheritEmbeddable_ {

	public static volatile SingularAttribute<TableForInheritEmbeddable, Weight> weight;
	public static volatile SingularAttribute<TableForInheritEmbeddable, Integer> id;
	public static volatile SingularAttribute<TableForInheritEmbeddable, Dimensions> dimensions;

	public static final String WEIGHT = "weight";
	public static final String ID = "id";
	public static final String DIMENSIONS = "dimensions";

}

