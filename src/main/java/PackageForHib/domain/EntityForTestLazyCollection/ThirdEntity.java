package PackageForHib.domain.EntityForTestLazyCollection;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@FetchProfiles({
        @FetchProfile(name = ThirdEntity.FETCH_PROFILE_FIRSTENTITY, fetchOverrides = @FetchProfile.FetchOverride(entity = ThirdEntity.class,association = "firstEntity",mode = FetchMode.JOIN)),
        @FetchProfile(name = ThirdEntity.FETCH_PROFILE_SECONDENTITY, fetchOverrides = @FetchProfile.FetchOverride(entity = ThirdEntity.class,association = "secondEntity",mode = FetchMode.JOIN))
}) // FetchProfile
@NamedEntityGraphs({
        @NamedEntityGraph(name = ThirdEntity.NAMED_ENTITY_GRAPH_FIRSTENTITY,attributeNodes = @NamedAttributeNode(value = "firstEntity")),
        @NamedEntityGraph(name = ThirdEntity.NAMED_ENTITY_GRAPH_FIRSTENTITY_WITH_SUB,attributeNodes = @NamedAttributeNode(value = "firstEntity",subgraph = "SubFor_FirstEntity"),
        subgraphs = {@NamedSubgraph(name = "SubFor_FirstEntity",attributeNodes = @NamedAttributeNode(value = "secondEntity"))})
}) // EntityGraph

@Entity
public class ThirdEntity {

    public static final String FETCH_PROFILE_FIRSTENTITY = "FETCH_PROFILE_FIRSTENTITY";
    public static final String FETCH_PROFILE_SECONDENTITY = "FETCH_PROFILE_SECONDENTITY";
    public static final String NAMED_ENTITY_GRAPH_FIRSTENTITY = "NAMED_ENTITY_GRAPH_FIRSTENTITY";
    public static final String NAMED_ENTITY_GRAPH_FIRSTENTITY_WITH_SUB = "NAMED_ENTITY_GRAPH_FIRSTENTITY_WITH_SUB";

    @Id
    @GeneratedValue
    protected int id;

//    @OneToMany(mappedBy = "thirdEntity",fetch = FetchType.EAGER) // тестив з FetchProfile
    @OneToMany(mappedBy = "thirdEntity",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    protected Set<FirstEntity> firstEntity = new HashSet<>();

    @OneToMany(mappedBy = "thirdEntity",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    protected Set<SecondEntity> secondEntity = new HashSet<>();



    public ThirdEntity() {

    }

    public void addFirstEntity(FirstEntity s) {
         firstEntity.add(s);
    }


    public void addSecondEntity(SecondEntity s) {
         secondEntity.add(s);
    }

    public Set<SecondEntity> getSecondEntity() {
        return secondEntity;
    }

    public Set<FirstEntity> getFirstEntity() {
        return firstEntity;
    }
}
