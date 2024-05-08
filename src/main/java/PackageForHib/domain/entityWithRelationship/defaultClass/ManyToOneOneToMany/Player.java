package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToOneOneToMany;


import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    protected int id;

    @ManyToOne()
    @JoinColumn(name = "host_id",nullable = false)
    protected Host host;

    public Player(Host host) {
        this.host = host;
    }

    public Player() {

    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", host=" + host +
                '}';
    }

    public Host getHost() {
        return host;
    }

    public int getId() {
        return id;
    }
}
