package PackageForHib.domain;


import org.hibernate.annotations.Loader;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@NamedNativeQuery(name = "NamedQueryForLoader", query = "SELECT * FROM entityformyfindloader ef WHERE ef.id = ?",
resultClass = EntityForMyFindLoader.class)

@NamedNativeQuery(name = "testproc",query = "SELECT * FROM procedureforloader(?)",resultClass = EntityForMyFindLoader.class)

@Loader(namedQuery = "testproc")
@Entity
public class EntityForMyFindLoader {

    @Id
    protected int id;


    protected String name;

    @Override
    public String toString() {
        return "EntityForMyFindLoader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
