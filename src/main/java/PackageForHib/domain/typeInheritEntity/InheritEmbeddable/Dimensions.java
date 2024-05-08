package PackageForHib.domain.typeInheritEntity.InheritEmbeddable;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverride(name = "typeSymbol", column = @Column(name = "Dimen_TypeSymbol"))
public class Dimensions extends Measurement{




    protected int height;

    public Dimensions(String typeSymbol, int height) {
        super(typeSymbol);
        this.height = height;
    }

    public Dimensions() {
        super();
    }
}
