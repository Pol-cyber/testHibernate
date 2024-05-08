package PackageForHib.domain.typeInheritEntity.thirdMethod;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Of")
public class Office extends Computer{

//    @Column(nullable = false)     //!!!!!!!!!!!! помилка!!! Класи що входять в одну таблиця за допомогою Inheritance(strategy = Inheritance.SINGLE_TABLE)
    // не повинні мати значення що не можуть бути null тому що при вставленні в цю одну таблицю всі колонки інших классів повинні мати null, таким чином
// якщо вставити інший класс який реалізує Computer буде виведено помилку
// "null значення в стовпці "countpeople" відношення "computer" порушує not-null обмеження"
    protected int countPeople;

    public Office(int countPeople,String owner) {
        super(owner);
        this.countPeople = countPeople;
    }

    public Office() {
        super();
    }
}
