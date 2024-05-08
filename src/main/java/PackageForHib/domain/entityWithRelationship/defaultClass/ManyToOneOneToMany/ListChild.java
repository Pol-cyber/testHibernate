package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ListChild {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne
    protected ListParent listParent;

    public void setListParent(ListParent listParent) {
        this.listParent = listParent;
    }
}
