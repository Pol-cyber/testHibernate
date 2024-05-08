package PackageForHib.domain.typeInheritEntity.firstMethod;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

//Одна таблица для каждого конкретного
//класса и неявный полиморфизм    (тобто в БД буде стільки таблиць скільки і сутностей, класс Animal не являється сутністю)
@MappedSuperclass
public abstract class Animal {

    protected String name;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    protected Date date;
}
