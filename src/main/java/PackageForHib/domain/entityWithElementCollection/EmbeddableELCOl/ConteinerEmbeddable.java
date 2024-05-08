package PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl;


import PackageForHib.domain.embeddableC.Image;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@SequenceGenerator(name = "seq_gen",sequenceName = "hibernate_sequence",allocationSize = 1)
public class ConteinerEmbeddable {

    @Id
    @GeneratedValue
    protected int id;


    @ElementCollection
    @CollectionTable()
    @Column()
    @CollectionId(column = @Column(name = "ConEmb_Id"), type = @Type(type = "long"),generator = "seq_gen")
    protected Collection<Image> images = new ArrayList<>();
}
