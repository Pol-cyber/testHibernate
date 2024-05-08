package PackageForHib.domain.entityWithElementCollection.EmbeddableWithELCol;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class House {

    protected int name;

    @ElementCollection
    @CollectionTable(name = "HausePeople",joinColumns = @JoinColumn(name = "City_id"))
    @Column(name = "peopleHome", nullable = false)
    protected Set<String> p = new HashSet<>(); //  зовнішній ключ буде зєднаний з первинним таблиці в яку
    // вставлений компонент (Embedddable), а сама таблиця буде скаладатись із 2 елементів
    // City_id(PK,FK)    peopleHome(PK)  -- peopleHome = PK тому що позначений як nullable = false
}
