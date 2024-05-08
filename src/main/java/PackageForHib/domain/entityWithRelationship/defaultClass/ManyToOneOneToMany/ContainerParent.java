package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ContainerParent {

    @Id
    @GeneratedValue
    protected int id;


    @OneToMany(mappedBy = "containerParent")
    protected Collection<ContainerChild> collection = new ArrayList<>(); // особливість контейнера в тому
    // що йому не приходиться перевіряти порядок елементів чи їх унікальність, а значить може не завантажувати
    // колекцію (не виконувати SELECT) поки не буде потреби пройтись по ній, тому ми зможемо вставляти нові
    // елементи без завантаження колекції.


}
