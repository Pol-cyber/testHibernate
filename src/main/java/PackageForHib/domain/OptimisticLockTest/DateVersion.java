package PackageForHib.domain.OptimisticLockTest;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DateVersion {

    @Id
    @GeneratedValue
    protected int id;

    @Version
    // Необязательно: @org.hibernate.annotations.Type(type = "dbtimestamp")
    //Вы можете переключиться на использование текущего времени сервера с баз дан-
    //ных, добавив аннотацию @org.hibernate.annotations.Type(type="dbtimestamp") пе-
    //ред свойством версии. В этом случае Hibernate будет запрашивать текущее время
    //у базы данных перед обновлением, например с помощью выражения call current_
    //timestamp() для базы данных H2. Это позволит использовать единый ресурс для
    //синхронизации времени. Не все SQL-диалекты Hibernate поддерживают это, по-
    //этому загляните в исходный код своего диалекта, чтобы узнать, переопределяет ли
    //он метод getCurrentTimestampSelectString(). Помимо этого, к базе данных проис-
    //ходит чрезмерное количество обращений при каждом увеличении номера версии.
    protected Date version;

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
