package guru.springframework.mrhpetclcinic.onetoone.uni1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oneToOne/organization")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationService organizationService, OrganizationRepository organizationRepository) {
        this.organizationService = organizationService;
        this.organizationRepository = organizationRepository;
    }

    //http://localhost:7070/oneToOne/organization/create
    @PostMapping("/create")
    public ResponseEntity<Object> createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    //http://localhost:7070/oneToOne/organization/get/{id}
    @GetMapping("/get/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        if(organizationRepository.findById(id).isPresent())
            return organizationRepository.findById(id).get();
        else return null;
    }

    //http://localhost:7070/oneToOne/organization/getAllOrganization
    @GetMapping("/getAllOrganization")
    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    //http://localhost:7070/oneToOne/organization/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOrganization(@PathVariable Long id) {
        if(organizationRepository.findById(id).isPresent()) {
            organizationRepository.deleteById(id);
            if (organizationRepository.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified organization");
            else return ResponseEntity.ok("Successfully deleted the specified organization");
        } else return ResponseEntity.unprocessableEntity().body("Specified organization not present");
    }
    //http://localhost:7070/oneToOne/organization/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrganization(@PathVariable Long id, @RequestBody Organization org) {
        return organizationService.updateOrganization(id, org);
    }
}
