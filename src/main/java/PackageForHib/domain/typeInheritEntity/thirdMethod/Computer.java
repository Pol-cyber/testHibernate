package PackageForHib.domain.typeInheritEntity.thirdMethod;


import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//единая таблица для целой иерархии классов: полиморфизм поддерживает-
//ся за счет денормализации схемы SQL, а определение суперкласса/подклас-
//са осуществляется посредством различения строк;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeColumn")
//@DiscriminatorFormula("CASE WHEN NAME IS NOT NULL THEN 'Ga' ELSE 'Of' END") // альтернатива @DiscriminatorColumn(name = "TypeColumn"), не створює
// стовпця в базі даних і буде оприділяти необхідний селектор (@DiscriminatorValue("??")) классу, тобто в який класс необхідно преобразити строку
public abstract class Computer {



    @Id
    @GeneratedValue
    protected int id;

    @NotNull
    @Column(nullable = false)
    protected String owner;


    public Computer(String owner) {
        this.owner = owner;
    }

    public Computer() {
       super();
    }
}
