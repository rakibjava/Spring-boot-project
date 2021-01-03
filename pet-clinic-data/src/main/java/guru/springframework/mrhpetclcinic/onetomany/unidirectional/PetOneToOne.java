package guru.springframework.mrhpetclcinic.onetomany.unidirectional;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "UniDirectionOneToOne_Pet")
public class PetOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "petName")
    private String petName;
    @Column(name = "petType")
    private String petType;
    @Column(name = "birthDate")
    private LocalDate birthDate;

    //omitted getter and setter

}
