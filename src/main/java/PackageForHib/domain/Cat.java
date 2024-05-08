package PackageForHib.domain;


import PackageForHib.domain.myEnum.AgeCat;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Cat{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @SequenceGenerator(name = "seq_generator", sequenceName = "sequence_forcat",allocationSize = 5)
    protected long id;

    @Column(updatable = false,insertable = false) // updatable и isertable виключає поле з INSERT AND UPDATE
    @ColumnDefault("4")
    @Generated(GenerationTime.INSERT) // Параметри вказує при якій операції SQL обновляти дані (екземпляр сутності)
    protected long teilLenght;

    protected String name;


    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP) // по умолчанию TemporalType.TIMESTAMP (якщо інший то автоматично перетворює тим
    // java.util.Date в потрібний java.sql)
    @Column(updatable = false)
//    @CreationTimestamp
    protected Date dateBorn;


    @Enumerated(EnumType.STRING) // По дефолту EnumType.ORDINAL - тобто будуть числа в порядку enum з 1
    protected AgeCat ageCat = AgeCat.UNKNOWN;

    public void setAgeCat(AgeCat ageCat) {
        this.ageCat = ageCat;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", teilLenght=" + teilLenght +
                ", name='" + name + '\'' +
                '}';
    }
}


