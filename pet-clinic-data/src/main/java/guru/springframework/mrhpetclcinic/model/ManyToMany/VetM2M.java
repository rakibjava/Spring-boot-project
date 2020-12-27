package guru.springframework.mrhpetclcinic.model.ManyToMany;

import guru.springframework.mrhpetclcinic.model.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vet_m2m")
public class VetM2M extends Person {

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "vet_specialities_m2m",
            joinColumns = {@JoinColumn(name = "vet_m2m_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialty_m2m_id")})
    private Set<SpecialtyM2M> specialities = new HashSet<>();

    public Set<SpecialtyM2M> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<SpecialtyM2M> specialities) {
        this.specialities = specialities;
    }

    public void addSpeciality(SpecialtyM2M course) {
        this.specialities.add(course);
        course.getVetM2MSpecialties().add(this);
    }

    public void removeCourse(SpecialtyM2M course) {
        this.specialities.remove(course);
        course.getVetM2MSpecialties().remove(this);
    }

    public void removeCourses() {
        for (SpecialtyM2M specialtyM2M : new HashSet<>(specialities)) {
            removeCourse(specialtyM2M);
        }
    }
}

