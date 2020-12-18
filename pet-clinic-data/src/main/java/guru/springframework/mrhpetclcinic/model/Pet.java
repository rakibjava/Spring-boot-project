package guru.springframework.mrhpetclcinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity{
    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="types_id")
    //@Transient
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private PetType petType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    //@JsonIgnore
    @JsonBackReference
    private Owner owner;

    @Column(name="birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    //@Transient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet",orphanRemoval = true)
    private Set<Visit> visits = new HashSet<>();

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", petType=" + petType +
               /* ", owner=" + owner +*/
                ", birthDate=" + birthDate +
                '}';
    }
}
