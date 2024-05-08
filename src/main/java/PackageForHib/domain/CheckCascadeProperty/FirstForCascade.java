package PackageForHib.domain.CheckCascadeProperty;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FirstForCascade {
    @Id
    @GeneratedValue
    protected int id;

    protected String text;

    @OneToMany(mappedBy = "firstForCascade",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE
    })
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REPLICATE}) // метод задання каскаду анотації Hibernate через анотацію
//    @Cascade. В анотації @OneToMany та інших можна використовуати лише
//    enum класс javax.persistence.CascadeType
    protected Set<SecondForCascade> secondForCascadeSet = new HashSet<>();


    public void addElement(SecondForCascade cascade){
        this.secondForCascadeSet.add(cascade);
    }

    public Set<SecondForCascade> getSecondForCascadeSet() {
        return secondForCascadeSet;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }
}
