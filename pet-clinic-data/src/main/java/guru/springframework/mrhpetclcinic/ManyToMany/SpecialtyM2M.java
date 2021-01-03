package guru.springframework.mrhpetclcinic.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import guru.springframework.mrhpetclcinic.model.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty_m2m")
public class SpecialtyM2M extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            mappedBy = "specialities")
   // @JsonIgnore
   @JsonBackReference
    private Set<VetM2M>  vetM2MSpecialties = new HashSet<>();

    public Set<VetM2M> getVetM2MSpecialties() {
        return vetM2MSpecialties;
    }

    public void setVetM2MSpecialties(Set<VetM2M> vetM2MSpecialties) {
        this.vetM2MSpecialties = vetM2MSpecialties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
