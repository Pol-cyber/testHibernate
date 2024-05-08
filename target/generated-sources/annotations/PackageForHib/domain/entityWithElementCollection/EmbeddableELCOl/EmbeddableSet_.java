package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;

import PackageForHib.domain.embeddableC.Image;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmbeddableSet.class)
public abstract class EmbeddableSet_ {

	public static volatile SetAttribute<EmbeddableSet, Image> images;
	public static volatile SingularAttribute<EmbeddableSet, Integer> id;

	public static final String IMAGES = "images";
	public static final String ID = "id";

}

