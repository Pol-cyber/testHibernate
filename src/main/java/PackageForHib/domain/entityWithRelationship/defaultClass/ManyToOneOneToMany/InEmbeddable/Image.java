package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.InEmbeddable;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue
    protected int id;

    protected Pazzle pazzle;
}
