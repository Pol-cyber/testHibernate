package PackageForHib.domain.entityWithElementCollection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// коллекції елементів дозволені повтори, но також підтримується порядок
@Entity
public class Army {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable(name = "Army_company")
    @OrderColumn
    @Column(name = "weapon")
    protected List<String> list = new ArrayList<>();


    public void addElement(String s){
        list.add(s);
    }

    public void deleteElement(int id){
        list.remove(id);
    }

    public List<String> getList() {
        return list;
    }

    public int getId() {
        return id;
    }
}
