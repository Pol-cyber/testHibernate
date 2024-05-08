package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContainerChild {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne
    protected ContainerParent containerParent;
}
