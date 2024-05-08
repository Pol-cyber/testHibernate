package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;

import PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.LinkTableForSTAndCO.Id;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LinkTableForSTAndCO.class)
public abstract class LinkTableForSTAndCO_ {

	public static volatile SingularAttribute<LinkTableForSTAndCO, Student> student;
	public static volatile SingularAttribute<LinkTableForSTAndCO, Course> course;
	public static volatile SingularAttribute<LinkTableForSTAndCO, Id> id;
	public static volatile SingularAttribute<LinkTableForSTAndCO, String> randomInfo;

	public static final String STUDENT = "student";
	public static final String COURSE = "course";
	public static final String ID = "id";
	public static final String RANDOM_INFO = "randomInfo";

}

