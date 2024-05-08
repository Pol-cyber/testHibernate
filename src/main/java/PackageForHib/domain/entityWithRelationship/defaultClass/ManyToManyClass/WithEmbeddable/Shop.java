package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithEmbeddable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shop {

    @Id
    @GeneratedValue
    protected int id;

    @ElementCollection
    @CollectionTable(name = "linkShopProd", joinColumns = @JoinColumn(name = "shop_id"))
    protected Set<EmbeddableLinkForShopAndProd> set = new HashSet<>();


    public void addElement(EmbeddableLinkForShopAndProd e){
        set.add(e);
    }
}
