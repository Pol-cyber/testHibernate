package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Human {


    @Id
    @GeneratedValue
    protected int id;

    @ManyToMany(mappedBy = "humans")
    protected Set<Animal> animals = new HashSet<>();
//    @OrderColumn
//    protected List<Animal> animals = new ArrayList<>();  // якщо потрібні індекси елементів
//    Отображать упорядоченные коллекции, такие как List, можно с помощью
//обычной аннотации @ManyToMany, но лишь с одной стороны. Помните, что в двуна-
//правленном отношении одна сторона отображается другой стороной, т. е. Hiber�nate будет игнорировать
// ее значение при синхронизации с базой данных. Если обе
//стороны представлены списками, сделать индексы элементов хранимыми можно
//только с одной стороны отношения.


}
