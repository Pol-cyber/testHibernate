package PackageForHib.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Employee> employee;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMPLOYEE = "employee";

}

