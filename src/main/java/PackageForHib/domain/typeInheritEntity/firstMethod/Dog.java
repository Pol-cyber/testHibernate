package PackageForHib.domain.typeInheritEntity.firstMethod;


import javax.persistence.*;

@Entity
@AttributeOverride(name = "name",column = @Column(name = "nameCat"))
public class Dog extends Animal{

    @Id
    @GeneratedValue
    protected long id;

    protected int age;
}
