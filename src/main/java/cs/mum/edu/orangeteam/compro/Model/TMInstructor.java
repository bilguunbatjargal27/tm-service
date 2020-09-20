package cs.mum.edu.orangeteam.compro.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class TMInstructor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    private String office;
    @Column(length = 120)
    private  String description;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "tmInstructor")
    private Collection<TMRecord> tmRecords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
