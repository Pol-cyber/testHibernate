package PackageForHib.domain.typeInheritEntity.thirdMethod;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ga")
public class Gaming extends Computer{

    protected String name;


    public Gaming(String name,String owner) {
        super(owner);
        this.name = name;
    }

    public Gaming() {

    }
}
