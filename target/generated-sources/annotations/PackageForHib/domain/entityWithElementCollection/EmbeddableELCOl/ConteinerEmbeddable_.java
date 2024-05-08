package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;

import PackageForHib.domain.embeddableC.Image;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConteinerEmbeddable.class)
public abstract class ConteinerEmbeddable_ {

	public static volatile CollectionAttribute<ConteinerEmbeddable, Image> images;
	public static volatile SingularAttribute<ConteinerEmbeddable, Integer> id;

	public static final String IMAGES = "images";
	public static final String ID = "id";

}

