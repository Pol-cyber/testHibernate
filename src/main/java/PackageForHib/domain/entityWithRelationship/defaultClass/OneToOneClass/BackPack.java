package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import javax.persistence.*;

@Entity
public class BackPack {

    @Id
    @GeneratedValue
    protected int id;

    @OneToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    protected Owner i;

}
