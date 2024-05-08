package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToMany
    @JoinTable(name = "HATable",
            joinColumns = @JoinColumn(name = "Animal_id"),
    inverseJoinColumns = @JoinColumn(name = "Human_id"))
    protected Set<Human> humans = new HashSet<>(); // якщо використовуати Collection (контейнер) то для повторних значень потрібно добавити
    // аннотацію  @CollectionId,
}
