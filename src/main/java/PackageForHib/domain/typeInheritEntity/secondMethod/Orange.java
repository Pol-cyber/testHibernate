package PackageForHib.domain.typeInheritEntity.secondMethod;



import javax.persistence.Entity;

@Entity
public class Orange extends Fruit {

    protected long age;

    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "age=" + age +
                ", id=" + id +
                '}';
    }
}
