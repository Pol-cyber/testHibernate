package PackageForHib.domain.typeInheritEntity.MixInheritance;


import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue
    protected long id;
}
