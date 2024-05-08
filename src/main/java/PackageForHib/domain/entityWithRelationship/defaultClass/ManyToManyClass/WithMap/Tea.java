package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithMap;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


// назва не дуже підходить но нічого
@Entity
public class Tea {

    @Id
    @GeneratedValue
    protected int id;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @MapKeyJoinColumn(name = "Mug_id")
    @JoinTable(name = "Tea_Link",
     joinColumns = @JoinColumn(name = "Tea_id"),
    inverseJoinColumns = @JoinColumn(name = "Spoon_id"))
    protected Map<Mug,Spoon>  map = new HashMap<>();
}
