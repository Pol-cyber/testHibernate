package PackageForHib.domain.entityWithRelationship.defaultClass.ManyToManyClass;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
public class LinkTableForSTAndCO {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "Student_id")
        private Long studentId;

        @Column(name = "Course_id")
        protected Long courseId;

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            } else if(obj == this){
                return true;
            }

            if(obj instanceof Id){
                return studentId.equals(((Id) obj).studentId) && courseId.equals(((Id) obj).courseId);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return studentId.hashCode() + courseId.hashCode();
        }
    }

    @EmbeddedId
    protected Id id = new Id();


    @Column(updatable = false)
    protected String randomInfo;

    @ManyToOne
    @JoinColumn(name = "Student_id",insertable = false,updatable = false)
    protected Student student;

    @ManyToOne
    @JoinColumn(name = "Course_id", insertable = false,updatable = false)
    protected Course course;

    public LinkTableForSTAndCO(Course course,Student student, String rInfo){

        randomInfo = rInfo;

        this.course = course;
        this.student = student;

        this.id.courseId = course.id;
        this.id.studentId = student.id;

        course.getSet().add(this); // гарантує посилальну цілісність
        student.getSet().add(this); // гарантує посилальну цілісність

    }

    public LinkTableForSTAndCO() {

    }
}
