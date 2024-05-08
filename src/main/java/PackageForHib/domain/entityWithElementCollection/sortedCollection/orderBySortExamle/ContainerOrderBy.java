package PackageForHib.domain.entityWithElementCollection.sortedCollection.orderBySortExamle;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@SequenceGenerator(name = "seq_gen",sequenceName = "hibernate_sequence",allocationSize = 1)
public class ContainerOrderBy {


    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable()
    @CollectionId(column = @Column(name = "Conteiner_Id"),type = @Type(type = "long"),generator = "seq_gen") // Для створенн поля
    // Primary key для таблички
    @Column(name = "ContainerString")
    @org.hibernate.annotations.OrderBy(clause = "ContainerString ASC")
    protected Collection<String> collection = new ArrayList<>();

    public void addElement(String s){
        collection.add(s);
    }

    public void getCollection() {
        collection.stream().forEach(System.out::println);
    }
}
