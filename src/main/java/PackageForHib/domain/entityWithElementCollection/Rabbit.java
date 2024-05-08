package PackageForHib.domain.entityWithElementCollection;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// Порядок елементів коллекції не важливий, но повторення забороняються
@Entity
public class Rabbit {

    @Id
    @GeneratedValue
    protected long id;

    @ElementCollection
    @CollectionTable(name = "RabbitCarrot",joinColumns = @JoinColumn(name = "Rbbit_Id"))
    @Column(name = "Rabbit_Carrot")
    protected Set<String> carrots = new HashSet<>();
}
