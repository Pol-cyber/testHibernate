package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithEmbeddable;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmbeddableLinkForShopAndProd.class)
public abstract class EmbeddableLinkForShopAndProd_ {

	public static volatile SingularAttribute<EmbeddableLinkForShopAndProd, Product> product;
	public static volatile SingularAttribute<EmbeddableLinkForShopAndProd, Bayer> bayer;
	public static volatile SingularAttribute<EmbeddableLinkForShopAndProd, String> info;

	public static final String PRODUCT = "product";
	public static final String BAYER = "bayer";
	public static final String INFO = "info";

}

