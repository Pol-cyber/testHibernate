package PackageForHib.domain.entityWithElementCollection;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

// дозволені повторення для значень коллекції та порядок неважливий
@Entity
@SequenceGenerator(name = "seq_gen",sequenceName = "hibernate_sequence",allocationSize = 1)
public class Airplane {

    @Id
    @GeneratedValue
    protected int id;


    @ElementCollection
    @CollectionTable(name = "Airplane_flight")
    @CollectionId(column = @Column(name = "flight_id"),type = @Type(type = "long"),generator = "seq_gen") // Для створенн поля
    // Primary key для таблички
    @Column(name = "flight")
    protected Collection<String> collection = new ArrayList<>();


    public void addElement(String s){
        collection.add(s);
    }

}
