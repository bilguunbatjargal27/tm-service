package cs.mum.edu.orangeteam.compro.DTO;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Faculty {

    private Long id;
    private String name;
    private Date hiringDate;
    private String room;
    private List<Course> teachingCourses = new ArrayList<>();
    private Address address;


}