package PackageForHib.domain.EntityListenersPriemniki;

import javax.persistence.PostLoad;

public class EntitityFirstListener {

    @PostLoad
    public void testListener(Object o){
        System.out.println("Працює");
    }
}
