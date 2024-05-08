package PackageForHib.domain.dataFilter;


import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@FilterDef(name = "text_filter",parameters = @ParamDef(name = "textpar",type = "string")) // є параметер defaultCondition, що встановляє
// условие по замовчуванням тобто не прийдеться в анотації @Filter писати condition
@Filter(name = "text_filter",condition = ":textpar LIKE 'FF%'")
public class TreeC {
    @Id
    @GeneratedValue
    protected int id;

    protected String text;


    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    protected Area area;


    public void setArea(Area area) {
        this.area = area;
    }
}
