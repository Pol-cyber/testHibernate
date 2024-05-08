package PackageForHib.domain.entityWithElementCollection.sortedCollection.comparatorSort;


import PackageForHib.myComparator.ReverseStringComparator;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class MapCompSort {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    @MapKeyColumn() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    @Column() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    @SortComparator(ReverseStringComparator.class)
    protected Map<String,String> map = new TreeMap<>();

    public void addElemnt(String key,String value){
        map.put(key, value);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
