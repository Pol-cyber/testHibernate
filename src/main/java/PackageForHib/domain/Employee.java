package PackageForHib.domain;


import javax.persistence.*;

@Entity
public class Employee {

    @Id
    protected int id;

    protected String name;

    @ManyToOne
    @JoinColumn(name = "Boss_id")
    protected Employee employee;
}
