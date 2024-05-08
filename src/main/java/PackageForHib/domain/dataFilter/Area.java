package PackageForHib.domain.dataFilter;


import org.hibernate.annotations.Filter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Area {

    @Id
    @GeneratedValue
    protected int id;

    @Filter(name = "text_filter",condition = ":textpar LIKE 'YESSS'")
    @OneToMany(mappedBy = "area")
    protected Set<TreeC> treeCSet = new HashSet<>();

    public Set<TreeC> getTreeCSet() {
        return treeCSet;
    }
}
