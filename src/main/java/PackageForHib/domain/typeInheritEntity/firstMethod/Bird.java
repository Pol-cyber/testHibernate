package PackageForHib.domain.typeInheritEntity.firstMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bird extends Animal{

    @Id
    @GeneratedValue
    protected long id;

    protected String type;
}
