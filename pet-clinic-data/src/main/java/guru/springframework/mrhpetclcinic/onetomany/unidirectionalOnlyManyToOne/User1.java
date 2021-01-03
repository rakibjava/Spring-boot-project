package guru.springframework.mrhpetclcinic.onetomany.unidirectionalOnlyManyToOne;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ManyToOneOnlyChildSide_User")
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNo")
    private String phoneNo;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "email")
    private String email;


    //omitted getter and setter
}
