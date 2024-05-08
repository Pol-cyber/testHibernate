package PackageForHib.domain.embeddableC;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Image.class)
public abstract class Image_ {

	public static volatile SingularAttribute<Image, String> filename;
	public static volatile SingularAttribute<Image, Integer> width;
	public static volatile SingularAttribute<Image, String> title;
	public static volatile SingularAttribute<Image, Integer> height;

	public static final String FILENAME = "filename";
	public static final String WIDTH = "width";
	public static final String TITLE = "title";
	public static final String HEIGHT = "height";

}

