package guru.springframework.mrhpetclcinic.onetomany.unidirectionalOnlyManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ManyToOneOnlyChildSide_Pet")
public class Pet1 {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "petName")
    private String petName;
    @Column(name = "petType")
    private String petType;
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public User1 user1;
    //omitted getter and setter
}
