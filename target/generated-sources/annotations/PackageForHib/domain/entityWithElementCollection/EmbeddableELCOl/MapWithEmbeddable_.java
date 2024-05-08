package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;

import PackageForHib.domain.embeddableC.Image;
import PackageForHib.domain.embeddableC.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MapWithEmbeddable.class)
public abstract class MapWithEmbeddable_ {

	public static volatile SingularAttribute<MapWithEmbeddable, Integer> id;
	public static volatile MapAttribute<MapWithEmbeddable, Region, Image> map;

	public static final String ID = "id";
	public static final String MAP = "map";

}

