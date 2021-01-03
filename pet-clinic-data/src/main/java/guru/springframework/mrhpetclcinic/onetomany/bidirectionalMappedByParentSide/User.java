package guru.springframework.mrhpetclcinic.onetomany.bidirectionalMappedByParentSide;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oneToManyBidirectionalUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNo")
    private String phoneNo;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "email")
    private String email;

    //mappedby define class will not hold the primary key, child class will own the parent primary key
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "user")
    List<PetAnimal> petAnimals = new ArrayList<>();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PetAnimal> getPetAnimals() {
        return petAnimals;
    }

    public void setPetAnimals(List<PetAnimal> petAnimals) {
        this.petAnimals = petAnimals;
    }
}
