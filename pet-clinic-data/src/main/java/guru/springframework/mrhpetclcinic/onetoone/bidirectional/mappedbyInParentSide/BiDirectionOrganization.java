package guru.springframework.mrhpetclcinic.onetoone.bidirectional.mappedbyInParentSide;

import javax.persistence.*;

@Entity
@Table(name = "organization_biDirection_mapped_parent")
public class BiDirectionOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String orgId;


    //parent table is using mappedBy so parent table will not store foreign key
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "biDirectionOrganization")
    private BiDirectionAddress biDirectionAddress;

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

    public BiDirectionAddress getBiDirectionAddress() {
        return biDirectionAddress;
    }

    public void setBiDirectionAddress(BiDirectionAddress biDirectionAddress) {
        this.biDirectionAddress = biDirectionAddress;
    }
}
