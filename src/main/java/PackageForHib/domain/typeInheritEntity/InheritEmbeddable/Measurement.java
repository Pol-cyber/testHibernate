package PackageForHib.domain.typeInheritEntity.InheritEmbeddable;


import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Measurement {

    protected String typeSymbol;


    public Measurement(String typeSymbol) {
        this.typeSymbol = typeSymbol;
    }


    public Measurement() {
    }
}
