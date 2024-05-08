package PackageForHib.domain.typeInheritEntity.InheritEmbeddable;


import javax.persistence.*;

@Embeddable
@AttributeOverride(name = "typeSymbol", column = @Column(name = "Weight_TypeSymbol"))
public class Weight extends Measurement{

    protected long value;


    public Weight(String typeSymbol, long value) {
        super(typeSymbol);
        this.value = value;
    }

    public Weight() {
       super();
    }
}
