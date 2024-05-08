package PackageForHib.domain.entityUseUserDomain;


import org.hibernate.annotations.Check;

import javax.persistence.*;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"emails"}))
public class TestDomainEmailAddress {

    @Id
    @GeneratedValue
    protected int id;

    @Column(
            nullable = false,
            columnDefinition = "EMAIL_ADDRESS"
    )
    protected String emails;


    @Column(columnDefinition = "VARCHAR(15) CHECK(NOT SUBSTRING(LOWER(EMAILS2),1,5) = 'admin')")
    protected String emails2;


    public void setEmails(String emails) {
        this.emails = emails;
    }

    public void setEmails2(String emails2) {
        this.emails2 = emails2;
    }

    public String getEmails() {
        return emails;
    }
}
