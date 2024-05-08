package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.NotNecessaryConnect;


import javax.persistence.*;


@Entity
public class Motorbike {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne
    @JoinTable(name = "MotoGarage", joinColumns = @JoinColumn(name = "Moto_id"),
            inverseJoinColumns = @JoinColumn(name = "Garage_id",nullable = false)) // оскільки зв'язок багато до одного, то
    // немає потреби робити unique для ключа garages як в @OneToOne
    protected Garage garages;
}
