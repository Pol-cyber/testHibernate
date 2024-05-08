package PackageForHib.domain.EntityForTestLazyCollection;


import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class SecondEntity {
    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne(fetch = FetchType.LAZY)
    protected FirstEntity firstEntity;
    @ManyToOne
    protected ThirdEntity thirdEntity;

    public void setFirstEntity(FirstEntity firstEntity) {
        this.firstEntity = firstEntity;
    }

    public int getId() {
        return id;
    }

    public FirstEntity getFirstEntity() {
        return firstEntity;
    }
}
