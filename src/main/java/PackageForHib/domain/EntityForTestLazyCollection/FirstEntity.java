package PackageForHib.domain.EntityForTestLazyCollection;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FirstEntity {

    @Id
    @GeneratedValue
    protected int id;

    @OneToMany(mappedBy = "firstEntity")
    @LazyCollection(LazyCollectionOption.EXTRA)  // це додаткове налаштування fetch = Lazy (якщо не вказати то LazyCollection немає сенсу)
    protected Set<SecondEntity> secondEntity = new HashSet<>(); // якщо ми зробимо виклик .size(), то воно зробить команду sql в базу даних і
    // збереже розмір колекції, наприклад:
    //         FirstEntity firstEntity = session.find(FirstEntity.class,185);
    //        System.out.println(firstEntity.getSecondEntity().size());
    //        session.detach(firstEntity);
    //        System.out.println(firstEntity.getSecondEntity().size());
    //        в даному тесті якщо закоментувати виклик до detach ми отримаємо LazyInitializationException, а якщо ні, то помилки не буде

    public Set<SecondEntity> getSecondEntity() {
        return secondEntity;
    }

    protected String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    protected ThirdEntity thirdEntity;

    public int getId() {
        return id;
    }
}
