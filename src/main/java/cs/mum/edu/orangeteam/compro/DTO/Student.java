package cs.mum.edu.orangeteam.compro.DTO;

import java.util.Date;

public class Student {

    private Long id;
    private String name;
    private Date enrollmentDate;
    private Address address;
    private double gpa;
    private Long tmInstructor;

    public Student() {
    }

    public Student(Long id, String name, Date enrollmentDate, Address address, double gpa, Long tmInstructor) {
        this.id = id;
        this.name = name;
        this.enrollmentDate = enrollmentDate;
        this.address = address;
        this.gpa = gpa;
        this.tmInstructor = tmInstructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Long getTmInstructor() {
        return tmInstructor;
    }

    public void setTmInstructor(Long tmInstructor) {
        this.tmInstructor = tmInstructor;
    }

    @Override
    public String toString() {
        return "CastStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", address=" + address +
                ", gpa=" + gpa +
                ", tmInstuctor=" + tmInstructor +
                '}';
    }

}