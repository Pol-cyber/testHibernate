package PackageForHib.domain.userType;

public abstract class ZipCode {

    protected String value;

    public ZipCode(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
