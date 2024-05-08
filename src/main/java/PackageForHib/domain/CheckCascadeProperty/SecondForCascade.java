package PackageForHib.domain.CheckCascadeProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SecondForCascade {
    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne
    protected FirstForCascade firstForCascade;

    public SecondForCascade(FirstForCascade firstForCascade) {
        this.firstForCascade = firstForCascade;
    }

    public SecondForCascade() {

    }

    public void setFirstForCascade(FirstForCascade firstForCascade) {
        this.firstForCascade = firstForCascade;
    }





    public int getId() {
        return id;
    }
}
