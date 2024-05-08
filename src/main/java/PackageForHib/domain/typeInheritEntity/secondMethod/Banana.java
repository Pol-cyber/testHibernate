package PackageForHib.domain.typeInheritEntity.secondMethod;


import javax.persistence.Entity;

@Entity
public class Banana extends Fruit {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Banana{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
