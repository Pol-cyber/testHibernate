package PackageForHib.domain.embeddableC;

import PackageForHib.domain.entityWithElementCollection.EmbeddableELCOl.EmbeddableSet;
import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Image {
    @Column(nullable = false)
    protected String title;
    @Column(nullable = false)
    protected String filename;
    protected int width;
    protected int height;



    public Image(String title, String filename, int width, int height) {
        this.title = title;
        this.filename = filename;
        this.width = width;
        this.height = height;
    }


    public Image() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image other = (Image) o;
        if (!title.equals(other.title)) return false;
        if (!filename.equals(other.filename)) return false;
        if (width != other.width) return false;
        if (height != other.height) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + filename.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }



}
