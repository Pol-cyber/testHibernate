package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    protected Long id;

    @OneToMany
    protected Set<LinkTableForSTAndCO> set = new HashSet<>();

    public Set<LinkTableForSTAndCO> getSet() {
        return set;
    }


}
