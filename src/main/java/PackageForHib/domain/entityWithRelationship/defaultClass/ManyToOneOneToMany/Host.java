package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;

import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SqlResultSetMapping(name = "HostResult", entities = {
        @EntityResult(entityClass = Host.class, fields = {
                @FieldResult(name = "id", column = "ID_Host"),
                @FieldResult(name = "text", column = "TEXT")
        }),
        @EntityResult(entityClass = Player.class, fields = {
                @FieldResult(name = "id", column = "ID_Player"),
                @FieldResult(name = "host", column = "ID_Host")
        })
})

@Loader(namedQuery = "ReturnHostWithPlayer")

@Entity
public class Host {

    @Id
    @GeneratedValue
    protected int id;

    protected String text;

    @OneToMany(mappedBy = "host",cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) // за допомогою
    // cascade - буде автоматично видаляти та вставляти всі Player разом із Host,тобто вставивши
    // елемент в колекцію її можна буде не зберігати (persist) hibernate виконає це автоматично
    // і так само із remove, виконавши remove для Host hibernate автоматично виконає операцію і
    // для Player. Також є параметер orphanRemoval = true він відповідає за видалення елемента з бази даних при
    // його видалені із колекції, но є дуже ризикованою - якщо елемент player ссилається на ще якийсь об'єкт за допомогою
    // зовнішнього ключа, то при видалені з колекції host значення не буде видалено із колекції другого елемента на яке він
    // ссилається (ст. 206)
//    @OnDelete(action = OnDeleteAction.CASCADE) // додає до зовнішнього ключа ON DELETE CASCADE, обычно находятся на
    // «другой» стороне mappedBy – там, где опре-
    // деляется отображение внешнего ключа/столбца соединения. Соответствующая
    // аннотация @OnDelete обычно помещается рядом с @ManyToOne в классе Player. Но если
    // связь двунаправленная, Hibernate распознает ее только на стороне @OneToMany
    protected Set<Player> playerSet = new HashSet<>();

    public void addElement(Player p){
        playerSet.add(p);
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", playerSet=" + playerSet +
                '}';
    }
}
