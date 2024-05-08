package PackageForHib.domain.embeddableC;

import PackageForHib.domain.Users;
import PackageForHib.domain.userType.ZipCode;
import PackageForHib.domain.userType.classConverter.ZipCodeToString;
import org.hibernate.annotations.Parent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


// встроений класс наслідує методи доступа (тобто чи звертається за допомогою методів доступу (get,set) чи полів) з сутності-власника
// Однак якщо написати Access  над самим класом Address, то буде використовуватись іменно призначений метод доступа
@Embeddable
public class Address {

//    @Column(nullable = false,length = 5)
//    protected String zipCode;

    @Convert(converter = ZipCodeToString.class)
    protected ZipCode zipCode;

    @NotNull // помилка (створена таблиця не буде мати NotNull як при створенні у сутності тому потрібно використовувати @Column(nullable = false
    // або @Basic(optional = false)))
    @Column(length = 25,nullable = false)
    protected String city;

    @AttributeOverrides(@AttributeOverride(name = "countPeople",column = @Column(name = "people")))
    protected Region region;

    public Address(ZipCode zipCode, String city, Region region) {
        this.zipCode = zipCode;
        this.city = city;
        this.region = region;
    }


//    public Address(String zipCode, String city) {
//        this.zipCode = zipCode;
//        this.city = city;
//    }



    public Address() {

    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }
    //    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
