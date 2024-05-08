package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;


import PackageForHib.domain.embeddableC.Image;
import PackageForHib.domain.embeddableC.Region;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MapWithEmbeddable {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable(name = "MapEbmeddable")
    protected Map<Region, Image> map = new HashMap<Region,Image>(); // ключом використовується Embeddable в даному
    // випадку не можуть використовуватись анотації @MapKeyColumn та @AttributeOvverides, кожне поле
    // ключового Embeddable повинно бути @Column(nullable = false) оскільки будуть в таблиці частиною
    // ключовими составного ключа
}
