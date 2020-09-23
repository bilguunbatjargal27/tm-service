package cs.mum.edu.orangeteam.compro.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//{
//        "id": 7,
//        "title": "WAA",
//        "building": "Vehrill",
//        "room": "102",
//        "startDate": "2020-01-01T00:00:00.000+00:00",
//        "endDate": "2020-02-01T00:00:00.000+00:00",
//        "tmAttendance": 0,
//        "grade": 12.0,
//        "facultyId": {
//        "id": 1,
//        "name": null,
//        "hiringDate": null,
//        "room": null,
//        "address": null
//        },
//        "studentId": {
//        "id": 610000,
//        "name": null,
//        "enrollmentDate": null,
//        "address": null,
//        "tmInstructor": null,
//        "canJobSearch": false,
//        "jobId": null,
//        "coachId": null,
//        "gpa": 0.0
//        },
//        "ta": false
//        }
public class Course {

    private Long id;
    private String title;
    private String building;
    private String room;
    private Date startDate;
    private Date endDate;
    private boolean isTA;
    private int tmAttendance;
    private double grade;
    private Faculty facultyId;
    private Student studentId;

}