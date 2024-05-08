package PackageForHib.domain.typeInheritEntity.MixInheritance;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mo")
public class Motorcycle extends Vehicle{

    protected long speed;
}
