package PackageForHib.domain.userType.classConverter;


import PackageForHib.domain.userType.MonetaryAmount;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter() // є аргумент autoApply = true який буде включати цей конвертер при кожному включені классу <?,anotherClass> ? в сутність
public class MonetaryAmountToString implements AttributeConverter<MonetaryAmount,String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        return monetaryAmount.toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String s) {
        return MonetaryAmount.toMonetary(s);
    }
}
