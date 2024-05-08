package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;


import javax.persistence.*;

@Entity
public class TestImmutableField {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "fKey")
    protected int fKey;

    @ManyToOne
    @JoinColumn(name = "fKey",insertable = false,updatable = false) // fkey стане зовнішнім ключем, помилки з одинаковими полями
    // не виникне оскільки поле host не використовується у вставці чи оновлені даних, однак при завантаженні строки з таблиці дані
    // поля отримаю
    protected Host host = new Host();
}
