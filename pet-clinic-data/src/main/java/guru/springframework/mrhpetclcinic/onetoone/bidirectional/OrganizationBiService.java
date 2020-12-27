package guru.springframework.mrhpetclcinic.onetoone.bidirectional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrganizationBiService {

    private final OrganizationBiRepository organizationBiRepository;
    private final AddressBiRepository addressBiRepository;

    public OrganizationBiService(OrganizationBiRepository organizationBiRepository, AddressBiRepository addressBiRepository) {
        this.organizationBiRepository = organizationBiRepository;
        this.addressBiRepository = addressBiRepository;
    }

    @Transactional
    public ResponseEntity<Object> createOrganization(OrganizationBi organization) {
        OrganizationBi org = new OrganizationBi();
        org.setName(organization.getName());
        org.setOrgId(organization.getOrgId());
        org.setAddress(organization.getAddress());
        OrganizationBi savedOrg = organizationBiRepository.save(org);
        if(organizationBiRepository.findById(savedOrg.getId()).isPresent())
            return ResponseEntity.ok().body("Organization created successfully.");
        else return ResponseEntity.unprocessableEntity().body("Failed to create the organization specified.");
    }

    @Transactional
    public ResponseEntity<Object> updateOrganization(Long id, OrganizationBi org) {

        if(organizationBiRepository.findById(id).isPresent()) {
            OrganizationBi organization = organizationBiRepository.findById(id).get();
            organization.setName(org.getName());
            organization.setOrgId(org.getOrgId());
            //organization.setAddress(org.getAddress());// this will make new address with new id
            // rather than get address by id and update.

            AddressBi addressBi = addressBiRepository.findById(organization.getAddress().getId()).get();
            addressBi.setBuilding(org.getAddress().getBuilding());
            addressBi.setCity(org.getAddress().getCity());
            addressBi.setCountry(org.getAddress().getCountry());
            addressBi.setState(org.getAddress().getState());
            addressBi.setStreet(org.getAddress().getStreet());
            addressBi.setZipcode(org.getAddress().getZipcode());
            addressBiRepository.save(addressBi);
            organization.setAddress(addressBi);


            OrganizationBi savedOrganization = organizationBiRepository.save(organization);

            if(organizationBiRepository.findById(savedOrganization.getId()).isPresent())
                return ResponseEntity.ok().body("Successfully Updated Organization");
            else return ResponseEntity.unprocessableEntity().body("Failed to update the specified Organization");
        } else return ResponseEntity.unprocessableEntity().body("The specified Organization is not found");
    }
}
