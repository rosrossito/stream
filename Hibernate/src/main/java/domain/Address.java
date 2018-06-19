package domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Address")
@Access(value = AccessType.FIELD)
public class Address {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue (generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {
            @Parameter(name = "property", value = "employee")
    })
    private Integer Id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee1 employee;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee1 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee1 employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
//                ", employee=" + employee +
                '}';
    }
}
