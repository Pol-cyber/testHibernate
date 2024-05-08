package PackageForHib.domain.typeInheritEntity.secondMethod;


import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

//одна таблица для каждого конкретного класса, но полное исключение по-
//лиморфизма и отношений наследования из схемы SQL. Для полиморфного
//поведения во время выполнения необходимо использовать запросы с SQL-
//инструкцией UNION;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Fruit {

    @Id
    @GeneratedValue
    protected long id;

}
