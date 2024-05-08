package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithEmbeddable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bayer {

    @Id
    @GeneratedValue
    protected int id;
}
