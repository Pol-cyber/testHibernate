package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import javax.persistence.*;

@Entity
public class Heart {

    @Id
    @GeneratedValue
    protected int id;
    
    
    @OneToOne(mappedBy = "heart",cascade = CascadeType.PERSIST) // встановлює двонаплавлений звязок
    protected People people;

    public int getId() {
        return id;
    }
}
