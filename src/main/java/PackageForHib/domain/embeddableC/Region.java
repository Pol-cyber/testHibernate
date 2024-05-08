package PackageForHib.domain.embeddableC;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Region {

    @Column(nullable = false)
    protected String country;

    @Column(nullable = false)
    protected int countPeople;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
}
