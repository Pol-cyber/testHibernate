package PackageForHib.domain;


import PackageForHib.domain.embeddableC.Address;
import org.jboss.jandex.Main;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Users {

    @Id
    @GeneratedValue
    protected long id;

    @AttributeOverrides(@AttributeOverride(name = "region.country",column = @Column(name = "peopCountry"))) // через . можна переоприділяти значення
    // компонентів на глибшому рівні
//    @Embedded // по суті робить те ж що @Embeddable, но пишеться в самій бітьківській сутності і використовується якщао немає
//    можливості написати @Embeddable перед классов, що повинен бути компонентом
    protected Address address;


//    @Valid // для того щоб перевірялась валідація для вкладеного компонента
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "cityTwo", length = 25)),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "zipcodeTwo", length = 5)),
//            @AttributeOverride(name = "region.countPeople",column = @Column(name = "newpeople"))
//    })
//    protected Address address2;

    public void setAddress(Address address) {
        this.address = address;
    }

//    public void setAddress2(Address address2) {
//        this.address2 = address2;
//    }
}
