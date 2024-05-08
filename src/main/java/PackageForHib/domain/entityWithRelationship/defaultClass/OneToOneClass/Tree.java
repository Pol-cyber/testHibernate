package PackageForHib.domain.entityWithRelationship.defaultClass.OneToOneClass;


import javax.persistence.*;

@Entity
public class Tree {

    @Id
    @GeneratedValue
    protected int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "TreeOwner",
            joinColumns = @JoinColumn(name = "Tree_id"),
            inverseJoinColumns = @JoinColumn(name = "Owner_id",unique = true,nullable = false)) // створює додаткову таблицю яка ссилається на Tree та Owner
    // зовнішнім ключем
    protected Owner owner;


    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
