package PackageForHib.domain;

import PackageForHib.domain.userType.MonetaryAmount;
import PackageForHib.domain.userType.classConverter.MonetaryAmountToString;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Має створені мною типи
@Entity
public class Balance {

    @Id
    @GeneratedValue
    protected long id;

    @Convert(converter = MonetaryAmountToString.class) // є параметр disableConversion який включає або виключає конвертер
    protected MonetaryAmount money;

    public MonetaryAmount getMoney() {
        return money;
    }

    public void setMoney(MonetaryAmount money) {
        this.money = money;
    }
}
