package PackageForHib.domain.entityWithElementCollection.sortedCollection.comparatorSort;


import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class SetNaturalSort {


    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable()
    @Column()
    @SortNatural()
    protected SortedSet<String> sortString = new TreeSet<>();

    public void addElement(String e){
        sortString.add(e);
    }


    public SortedSet<String> getSortString() {
        return sortString;
    }
}
