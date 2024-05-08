package PackageForHib.domain.CheckCascadeProperty;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FirstForCascade.class)
public abstract class FirstForCascade_ {

	public static volatile SetAttribute<FirstForCascade, SecondForCascade> secondForCascadeSet;
	public static volatile SingularAttribute<FirstForCascade, Integer> id;
	public static volatile SingularAttribute<FirstForCascade, String> text;

	public static final String SECOND_FOR_CASCADE_SET = "secondForCascadeSet";
	public static final String ID = "id";
	public static final String TEXT = "text";

}

