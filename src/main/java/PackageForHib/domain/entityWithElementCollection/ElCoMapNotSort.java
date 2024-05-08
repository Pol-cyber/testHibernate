package PackageForHib.domain.entityWithElementCollection;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


// словник тобто map (колекція ключ - значення) без сортування
@Entity
public class ElCoMapNotSort {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    @MapKeyColumn() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    @Column() // оскільки не зробив name = "" буде присвоєно дефолтне значення
    protected Map<String,String> mapNS = new HashMap<>();
}
