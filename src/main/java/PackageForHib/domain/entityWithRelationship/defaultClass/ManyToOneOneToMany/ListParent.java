package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ListParent {

    @Id
    @GeneratedValue
    protected int  id;

    @OneToMany(mappedBy = "listParent")
    @OrderColumn(name = "child_index")
    protected List<ListChild> list = new ArrayList<>();

    public void addElement(ListChild listChild){
        list.add(listChild);
    }
}
