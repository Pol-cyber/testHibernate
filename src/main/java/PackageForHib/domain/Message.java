package PackageForHib.domain;


import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Якщо є xml-дискриптор (resources/META-ING/orm.xml), то аннотації сущності упускаються і буде використовуватись лише він
// сам файл для даного классу:
// <entity-mappings xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm" version="2.1">
//
//    <entity class="PackageForHib.domain.Message" access="FIELD">
//        <attributes>
//            <id name="id">
//                <generated-value strategy="AUTO"/>
//            </id>
//            <basic name="text"/>
//        </attributes>
//    </entity>
//</entity-mappings>
// Також може використовуватись hibenrate XML-дискриптор для заміни
// аннотацій (розташований у файлі resouses/%.hbm.xml (% - люба назва файлу))


//@org.hibernate.annotations.GenericGenerator(
//        name = "ID_GENERATOR",
//        strategy = "enhanced-sequence",
//        parameters = {
//        @org.hibernate.annotations.Parameter(
//                name = "sequence_name",
//                value = "\"myTestSequence\""
//        ),
//        @org.hibernate.annotations.Parameter(
//                name = "initial_value",
//                value = "1000"
//        )
//})

@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "MessageResult",
                entities = @EntityResult(
                        entityClass = Message.class,
                        fields = {
                                @FieldResult(name = "id", column = "id"),
                                @FieldResult(name = "text", column = "TextNew")
                        }
                )
        )
)


@Entity
@SequenceGenerator(name = "myGeneratorName", sequenceName = "myTestSequence",initialValue = 20,allocationSize = 32)
//@Immutable  //показує те що екземпляри класу є незмінними тобто hibernate не буде перевіряти стан обєкта і виконувати операцію UPDATE
//@SequenceGenerator(name = "my_seq", sequenceName = "my_sequence", allocationSize = 1)
@Audited
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myGeneratorName")
//    @GeneratedValue(generator = "ID_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_seq")
    private long id;

    @Size(min = 4, max = 25, message = "Size Is INCORRECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    private String text;




//    @Formula("(select AVG(m.id) FROM Message m)") // рахуй що селект при отриманні обєкта став таким SELECT id,text, (SELECT AVG(id) FROM Message)
//    protected int description;                                                                    // FROM Message
// не підтримується Hibernate Envers


    public Message( String text) {
        this.text = text;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

//    public int getDescription() {
//        return description;
//    }
}

