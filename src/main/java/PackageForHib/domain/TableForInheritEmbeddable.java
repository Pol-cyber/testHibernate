package PackageForHib.domain;


import PackageForHib.domain.typeInheritEntity.InheritEmbeddable.Dimensions;
import PackageForHib.domain.typeInheritEntity.InheritEmbeddable.Measurement;
import PackageForHib.domain.typeInheritEntity.InheritEmbeddable.Weight;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TableForInheritEmbeddable {

    @Id
    @GeneratedValue
    protected int id;

    protected Dimensions dimensions;

    protected Weight weight;

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

}
