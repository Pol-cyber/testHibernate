package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany.InEmbeddable;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Pazzle {

    @NotNull
    @Column(nullable = false)
    protected String size;


    @OneToMany
    @JoinColumn(name = "Pazzle_part",nullable = false)
    // @JoinTable(name = "PazzleRel", joinColumns = @JoinColumn(name = "Image_id"),
    //            inverseJoinColumns = @JoinColumn(name = "Rel_id",nullable = false))  // використовується для необов'язкового
    //            звязку (створює додаткову таблицю) якщо не потрібно колонок із значенням null
    //            (якщо звязок є, то і строка буде якщо ні то строки не буде)
    protected Set<RelationForPazzle> relationForPazzleSet = new HashSet<>();

}
