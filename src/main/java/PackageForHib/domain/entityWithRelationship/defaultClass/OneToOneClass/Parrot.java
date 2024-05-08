package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Parrot {

    @Id
    @GeneratedValue(generator = "id_owner_generator")
    @GenericGenerator(
            name = "id_owner_generator",
            strategy = "foreign",
            parameters = @Parameter(name = "property",value = "owner")
    )
    protected int id;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @PrimaryKeyJoinColumn
    protected Owner owner;


    public Parrot(Owner owner){
        this.owner = owner;

    }

    public Parrot() {

    }
}
