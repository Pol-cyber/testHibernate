package PackageForHib.domain;


import org.hibernate.annotations.AttributeAccessor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;


@Entity
public class Item {

    @Id
    @GeneratedValue
//    @Access(AccessType.FIELD) //  вказує метод доступу по полю чи методу, також в залежності від метода доступу
//    всі аннотації повинні розташовуватись відповідно нього, якщо поставим Access(AccessType.FIELD) над get (геттером) то інші
//    аннотації що стосуються цього поля також повинні знаходитись над гетером. Якщо правильно розумію,
//    то розмістивши перед классом буде стосуватись усіх сутностей, а якщо перед полем то тільки його.
    protected Long id;

//    @AttributeAccessor("noop") // якщо я правильно розумію змінна позначена цією анотацією не буде
//    змінювати своє значення навіть після set, вона повинна автоматично змінюватись відповідно до тригерів бази даних
//    тобто це змінна, що створена і використовується лише в Query запитах JPA
//    Що стосується @AttributeAccessor("??") замість ?? може бути ваш клас доступу який реалізує
//    інтерфейс org.hibernate.property.PropertyAccessor
//    protected int validated;
    @Column(name = "validated")
//    @ColumnDefault("20")
    @ColumnTransformer(read = "validated * 30", write = "?/30") // змінює значення для читання та записування (? обовязковий параметер)
    // який означає testColumn в даному випадку. Я попробував і думаю селект виглядає так SELECT * FROM Item WHERE validated * 30 = ?
    // (тут знак питання написав сам і він означає символ який ми написали для зрівнення). Запис ж INSERT INTO table VALUES (?/30)
    protected int testColumn;
    public Long getId() {
        return id;
    }

    public void setTestColumn(int validated) {
        this.testColumn = validated;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", testColumn=" + testColumn +
                '}';
    }
}
