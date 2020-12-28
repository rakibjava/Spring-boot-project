package guru.springframework.mrhpetclcinic.onetoone.uindirectional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final AddressRepository addressRepository;

    public OrganizationService( OrganizationRepository organizationRepository, AddressRepository addressRepository) {
        this.organizationRepository = organizationRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public ResponseEntity<Object> createOrganization(Organization organization) {
        Organization org = new Organization();
        org.setName(organization.getName());
        org.setOrgId(organization.getOrgId());
        org.setAddress(organization.getAddress());
        Organization savedOrg = organizationRepository.save(org);
        if(organizationRepository.findById(savedOrg.getId()).isPresent())
            return ResponseEntity.ok().body("Organization created successfully.");
        else return ResponseEntity.unprocessableEntity().body("Failed to create the organization specified.");
    }

    @Transactional
    public ResponseEntity<Object> updateOrganization(Long id, Organization org) {

        if(organizationRepository.findById(id).isPresent()) {
            Organization organization = organizationRepository.findById(id).get();
            organization.setName(org.getName());
            organization.setOrgId(org.getOrgId());
            //organization.setAddress(org.getAddress());// this will make new address with new id
            // rather than get addrress by id and update.
            Address address = addressRepository.findById(organization.getAddress().getId()).get();
            System.out.println("Testing AddressId==:"+ address);
            address.setBuilding(org.getAddress().getBuilding());
            address.setCity(org.getAddress().getCity());
            address.setCountry(org.getAddress().getCountry());
            address.setState(org.getAddress().getState());
            address.setStreet(org.getAddress().getStreet());
            address.setZipcode(org.getAddress().getZipcode());
            //addressRepository.save(address);
            organization.setAddress(address);


            Organization savedOrganization = organizationRepository.save(organization);

            if(organizationRepository.findById(savedOrganization.getId()).isPresent())
                return ResponseEntity.ok().body("Successfully Updated Organization");
            else return ResponseEntity.unprocessableEntity().body("Failed to update the specified Organization");
        } else return ResponseEntity.unprocessableEntity().body("The specified Organization is not found");
    }
}
