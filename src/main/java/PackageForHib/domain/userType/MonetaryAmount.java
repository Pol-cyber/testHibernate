package PackageForHib.domain.userType;

import java.io.Serializable;
import java.util.Currency;

public class MonetaryAmount implements Serializable {

     protected int value;

     protected Currency currency;


    public int getValue() {
        return value;
    }

//    public void setValue(int value) {
//        this.value = value;
//    }

    public Currency getCurrency() {
        return currency;
    }

//    public void setCurrency(Currency currency) {  //  Оскільки сеттерів немає то класс можна назвати незмінним
//        this.currency = currency;
//    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        } else if(obj == null){
            return false;
        } else if(obj instanceof MonetaryAmount){
            return ((MonetaryAmount) obj).value == value && ((MonetaryAmount) obj).currency.toString().equals(currency.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        result = value  % 993;
        result = 29 * result + currency.hashCode();
        return result;
    }

    public MonetaryAmount(int value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return value +" " + currency;
    }

    public static MonetaryAmount toMonetary(String s) {
        String[] st = s.split(" ");
        if(st.length == 2) {
            return new MonetaryAmount(Integer.parseInt(st[0]),Currency.getInstance(st[1]));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
