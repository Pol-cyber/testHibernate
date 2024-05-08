package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import javax.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    protected int id;

    @OneToOne(mappedBy = "owner",cascade = CascadeType.PERSIST)
    protected Parrot parrot;

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
