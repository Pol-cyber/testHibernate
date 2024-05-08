package PackageForHib.domain.userType;

public class GermanCode extends ZipCode {


    public GermanCode(String value) {
        super(value);
        if(value.length() != 5) {
            throw new RuntimeException();
        }
    }
}
