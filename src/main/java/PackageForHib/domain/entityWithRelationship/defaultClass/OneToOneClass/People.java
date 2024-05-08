package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import javax.persistence.*;
import java.io.Serializable;


@Entity
public class People{

    @Id
    protected int name;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @PrimaryKeyJoinColumn
    protected Heart heart;


    public People(int name) {
        this.name = name;
    }

    public People() {

    }
}
