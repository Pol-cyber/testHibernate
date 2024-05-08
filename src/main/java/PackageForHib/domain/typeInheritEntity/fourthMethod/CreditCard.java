package PackageForHib.domain.typeInheritEntity.fourthMethod;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "CreditCard_ID") // переоприділяє назву
// @ID стовпця BillingDetails, якщо немає цієї аннотацію,
// то стовпець має назву змінної @Id BillingDetails
public class CreditCard extends BillingDetails{

    @NotNull
    protected String cardNumber;
    @NotNull
    protected String expMonth;
    @NotNull
    protected String expYear;

    public CreditCard(String cardNumber, String expMonth, String expYear) {
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public CreditCard() {

    }
}
