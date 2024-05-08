package PackageForHib.domain.userType.classConverter;

import PackageForHib.domain.userType.GermanCode;
import PackageForHib.domain.userType.SwissCode;
import PackageForHib.domain.userType.ZipCode;

import javax.persistence.AttributeConverter;


public class ZipCodeToString implements AttributeConverter<ZipCode,String> {
    @Override
    public String convertToDatabaseColumn(ZipCode zipCode) {
        return zipCode.toString();
    }

    @Override
    public ZipCode convertToEntityAttribute(String s) {
        if(s.length() == 5){
            return new GermanCode(s);
        } else if (s.length() == 4){
            return new SwissCode(s);
        }
        throw new RuntimeException();
    }
}
