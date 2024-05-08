package PackageForHib.domain.OptimisticLockTest;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "TestVersionOpLock")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,region = "PackageForHib.domain.OptimisticLockTest.LongVersion")
public class LongVersion {

    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "versionL")
    @Version
    protected Long version;

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getVersion() {
        return version;
    }
}
