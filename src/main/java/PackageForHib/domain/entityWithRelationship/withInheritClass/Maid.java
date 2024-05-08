package PackageForHib.domain.entityWithRelationship.withInheritClass;


import PackageForHib.domain.typeInheritEntity.fourthMethod.BillingDetails;

import javax.persistence.*;

@Entity
public class Maid {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne(fetch = FetchType.LAZY)   //fetch стоїть в lazy а значить не буде завантажено обєктва з бази даних (можна привести аналогію з load методом session)
    // обєкт буде завантажуватись лише за потреби. Ліниве завантаження означає, що асоціації не будуть завантажені з бази даних, поки до них не звернеться
    // код програми. Це може допомогти зменшити кількість запитів до бази даних та покращити продуктивність.
    protected BillingDetails billingDetails;


    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public int getId() {
        return id;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }
}
