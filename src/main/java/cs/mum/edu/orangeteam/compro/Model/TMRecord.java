package cs.mum.edu.orangeteam.compro.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TMRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date checkingDate;
    private Integer numberOfTMchecking;
    @ManyToOne
    private TMInstructor tmInstructor;
    private Long studentId;

    public TMRecord() {
    }

    public Date getCheckingDate() {

        return checkingDate;
    }

    public void setCheckingDate(Date checkingDate) {
        this.checkingDate = checkingDate;
    }

    public Integer getNumberOfTMchecking() {
        return numberOfTMchecking;
    }

    public void setNumberOfTMchecking(Integer numberOfTMchecking) {
        this.numberOfTMchecking = numberOfTMchecking;
    }

    public TMInstructor getTmInstructor() {
        return tmInstructor;
    }

    public void setTmInstructor(TMInstructor tmInstructor) {
        this.tmInstructor = tmInstructor;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
