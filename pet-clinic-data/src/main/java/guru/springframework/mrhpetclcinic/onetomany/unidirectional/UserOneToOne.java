package guru.springframework.mrhpetclcinic.onetomany.unidirectional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UniDirectionOneToOne_User")
public class UserOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_pet_id", referencedColumnName = "id")
    List<PetOneToOne> petOneToOnes = new ArrayList<>();

    //omitted getter and setter
}
