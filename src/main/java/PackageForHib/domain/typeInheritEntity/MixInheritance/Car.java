package PackageForHib.domain.typeInheritEntity.MixInheritance;


import javax.persistence.*;

@Entity
@DiscriminatorValue("Ca")
@SecondaryTable(name = "secondaryCar", pkJoinColumns = @PrimaryKeyJoinColumn(name = "Car_ID"))
public class Car extends Vehicle{

    @Column(table = "secondaryCar")
    protected String name;


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
