package PackageForHib.domain.entityWithElementCollection.sortedCollection.orderBySortExamle;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class SetWithOrderBy {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection()
    @CollectionTable()
    @Column(name = "StringElement")
    @org.hibernate.annotations.OrderBy(clause = "StringElement DESC") // також є аналог javax.persistence.OrderBy однак для
    // елементів колекцій доступний лише ASC порядок тому що @OrderBy("name DESC") приймає іменно назви полів що містяться
    // всередині обєкта для якого призначений (ст.192)
    protected Set<String> stringSet = new LinkedHashSet<>();

    public void addElement(String s){
        stringSet.add(s);
    }

    public Set<String> getStringSet() {
        return stringSet;
    }
}
