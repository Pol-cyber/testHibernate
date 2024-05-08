package PackageForHib.domain.entityWithRelationship.withInheritClass;

import PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    protected int id;

    @OneToMany(mappedBy = "customer")
    protected Set<BillingDetails> billingDetailsSet = new HashSet<>();
}
