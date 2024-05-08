package PackageForHib.domain.EntityListenersPriemniki;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityListeners(value = {
        EntitityFirstListener.class
})
public class EntityForListener {
    @Id
    @GeneratedValue
    protected int id;


}
