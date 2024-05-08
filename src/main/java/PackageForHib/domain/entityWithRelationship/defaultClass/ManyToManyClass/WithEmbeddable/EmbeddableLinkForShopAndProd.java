package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass.WithEmbeddable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class EmbeddableLinkForShopAndProd {

    @ManyToOne
    @JoinColumn(name = "Product_id", nullable = false,updatable = false) // ?????? (так пише в книжці, однак на практиці з використанням Set,
    // всі значення будуть просто зовнішніми ключами до того моменту поки всі поля @Embeddable не будуть мати значення nullable = false)
    // поля позначені nullable = false автоматично являються первинними ключами
    protected Product product;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "Bayer_id", updatable = false) // поле не повинно бути первинним ключем, анотація @NotNull в @Embeddable не робить
    // значення первинним ключем
    protected Bayer bayer;

    @NotNull
    @Column(updatable = false)
    protected String info;


    public EmbeddableLinkForShopAndProd(Product p, Bayer b, String i){
        bayer = b;
        product = p;
        info = i;
    }

    public EmbeddableLinkForShopAndProd() {

    }
}
