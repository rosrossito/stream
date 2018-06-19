package domain;

import com.sun.jndi.cosnaming.IiopUrl;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table (name="Employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"Id"})})
@Access(value = AccessType.FIELD)
public class Employee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true, length = 11)
    private Integer Id;

    @Column(name="name", length = 20)
    private String name;

    @Column(name="role", length = 20)
    private String role;

    @Column(name="insert_time")
    private Date insertTime;

    @OneToOne (mappedBy = "employee")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer  getId() {
        return Id;
    }

    public void setId(Integer  id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", insertTime=" + insertTime +
                ", {Address= " + address + "}" +
                '}';
    }
}
