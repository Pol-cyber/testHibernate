package PackageForHib.domain;


import PackageForHib.domain.userType.MonetaryAmount;
import PackageForHib.domain.userType.hibernateAdapterUserType.MonetaryAmountUserType;
import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@TypeDefs({@TypeDef(name = "type_for_USD",typeClass = MonetaryAmountUserType.class,parameters = {@Parameter(name = "convertTo",value = "USD")}),
        @TypeDef(name = "type_for_EUR",typeClass = MonetaryAmountUserType.class,parameters = {@Parameter(name = "convertTo",value = "EUR")})})
@Entity
public class ForUserType {

    @Id
    @GeneratedValue
    protected int id;


    @Type(type = "type_for_USD")
    @Columns(columns = {@Column(name = "moeneyUSD"),@Column(name = "currencyUSD")})
    protected MonetaryAmount monetaryUSD;

    @Type(type = "type_for_EUR")
    @Columns(columns = {@Column(name = "moeneyEUR"),@Column(name = "currencyEUR")})
    protected MonetaryAmount monetaryEUR;

    public MonetaryAmount getMonetaryUSD() {
        return monetaryUSD;
    }

    public void setMonetaryUSD(MonetaryAmount monetaryUSD) {
        this.monetaryUSD = monetaryUSD;
    }

    public MonetaryAmount getMonetaryEUR() {
        return monetaryEUR;
    }

    public void setMonetaryEUR(MonetaryAmount monetaryEUR) {
        this.monetaryEUR = monetaryEUR;
    }
}
