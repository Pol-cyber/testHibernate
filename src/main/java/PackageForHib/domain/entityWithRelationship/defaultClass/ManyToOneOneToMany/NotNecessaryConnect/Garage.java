package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.NotNecessaryConnect;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Garage {
    @Id
    @GeneratedValue
    protected int id;

    @OneToMany(mappedBy = "garages")
    protected Set<Motorbike> motorbikes = new HashSet<>();
}
