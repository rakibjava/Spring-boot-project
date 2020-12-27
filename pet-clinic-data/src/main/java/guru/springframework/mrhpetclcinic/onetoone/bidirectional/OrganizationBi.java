package guru.springframework.mrhpetclcinic.onetoone.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "organization_biDirection")
public class OrganizationBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String orgId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_biDirection_id",referencedColumnName = "id")
   //@OneToOne(targetEntity = AddressBi.class, cascade = CascadeType.ALL) // if use this then turn off other two lines
    private AddressBi addressBi;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public AddressBi getAddress() {
        return this.addressBi;
    }

    public void setAddress(AddressBi addressBi) {
        this.addressBi = addressBi;
    }
}
