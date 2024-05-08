package PackageForHib.domain;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Clob;
import java.util.Currency;

@Entity
public class HereByte {

    @Id
    @GeneratedValue
    protected int anInt;

    @Lob
    protected byte[] myarray;

//    @Lob        // оприділяє тип як BLOB(для бінарних значень) або CLOB(для символів) у випадку з PostgreSQL створює тип oid
    //К сожалению, даже такая настройка не обеспечивает отложенную загрузку.
    //Hibernate придется перехватывать доступ к полю и, например, загружать байты
    //для поля name в момент вызова метода someHereByte.getName(). Подобный подход
    //требует внедрения дополнительного кода в байт-код классов после компиляции.
//    protected String name;

    @Lob
    protected java.sql.Clob name; // пряме призначення типу CLOB, анотація @Lob тут обов'язкова
    //Если для свойства в Java
    //выбрать тип java.sql.Clob или java.sql.Blob, это обеспечит отложенную загрузку
    //без внедрения в байт-код.

    @Type(type = "string")
    protected short testValue;


    public Clob getName() {
        return name;
    }

    public void setName(Clob name) {
        this.name = name;
    }
}
