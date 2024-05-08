package PackageForHib.domain.myview;


import PackageForHib.domain.Message;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


// В Subselect краще отримувати всі поля, що хочеш використати інакше може виникнути помилка could not extract ResultSet
@Entity
@Immutable
@Subselect(
        "SELECT m.id, m.text FROM Message m"
)
@Synchronize({"Message"}) // для того щоб Hibernate знав про необхідність синхронізації
// Обратите внимание, что Hibernate не выполняет автоматической синхрониза-
//ции перед операцией find() – только перед выполнением запроса (Query), если это
//необходимо.
//!!!!!!!!!!!!!!!!!! ДАНИЙ VIEW працює для програми а не створений в базі даних ст.108
public class ViewMessage {

    @Id
    private long id;

    private String text;

    @Override
    public String toString() {
        return "ViewMessage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
