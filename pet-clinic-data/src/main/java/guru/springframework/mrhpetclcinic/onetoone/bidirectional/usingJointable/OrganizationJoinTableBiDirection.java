package guru.springframework.mrhpetclcinic.onetoone.bidirectional.usingJointable;

import javax.persistence.*;

@Entity
@Table(name = "OrganizationJoinTable")
public class OrganizationJoinTableBiDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String orgId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "org_address_joined",
        joinColumns =
                {@JoinColumn(name = "OrganizationJoinTableJoinTable_id",referencedColumnName = "id")},
        inverseJoinColumns =
                {@JoinColumn(name = "AddressJoinTable_id",referencedColumnName = "id")}
       )
    private AddressJoinTableBiDirection addressJoinTableBiDirection;

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

    public AddressJoinTableBiDirection getBiDirectionAddress() {
        return addressJoinTableBiDirection;
    }

    public void setBiDirectionAddress(AddressJoinTableBiDirection addressJoinTableBiDirection) {
        this.addressJoinTableBiDirection = addressJoinTableBiDirection;
    }
}
