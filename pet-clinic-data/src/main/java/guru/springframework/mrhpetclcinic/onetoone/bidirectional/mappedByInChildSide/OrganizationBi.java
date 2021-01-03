package guru.springframework.mrhpetclcinic.onetoone.bidirectional.mappedByInChildSide;

import javax.persistence.*;

@Entity
@Table(name = "organization_biDirection")
public class OrganizationBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String orgId;

    //JoinColumn in Parent side and mappedBy in child side mean parent table will store the
    // foreign key means hold the child table primary key
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_biDirection_id",referencedColumnName = "id")

    // If use below mapping then parent table will not store the foreign key.
    // rather than child table hold the parent table primary key
    //if below turned on then  on the child side must be turned on this /*@OneToOne @JoinColumn(name = "organizationBi_id")*/

    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "organizationBi")*/
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
