package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;

import PackageForHib.domain.embeddableC.Image;
import PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.Host;
import org.hibernate.annotations.Parent;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EmbeddableSet {

    @Id
    @GeneratedValue
    protected int id;


    @ElementCollection
    @CollectionTable(name = "EmbedASet_Image")
    protected Set<Image> images = new HashSet<>(); //інтересна особоливість якщо всі сутності Image будуть
    // NOT NULL, то в базу даних буде відображено кожен параметер як ключовий, якщо правильно зрозумів
    // працює лише з колекцією Set



    public void addElement(Image image){
        images.add(image);
    }

    public Set<Image> getImages() {
        return images;
    }

    public int getId() {
        return id;
    }
}
