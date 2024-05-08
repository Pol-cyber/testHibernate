package PackageForHib.domain.userType;

public class SwissCode extends ZipCode {

    public SwissCode(String value) {
        super(value);
        if(value.length() != 4) {
            throw new RuntimeException();
        }
    }

}
