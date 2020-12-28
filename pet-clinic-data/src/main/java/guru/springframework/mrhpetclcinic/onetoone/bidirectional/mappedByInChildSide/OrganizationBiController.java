package guru.springframework.mrhpetclcinic.onetoone.bidirectional.mappedByInChildSide;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oneToOne/organization/bi")
public class OrganizationBiController {

    private final OrganizationBiService organizationBiService;
    private final OrganizationBiRepository organizationBiRepository;

    public OrganizationBiController(OrganizationBiService organizationBiService, OrganizationBiRepository organizationBiRepository) {
        this.organizationBiService = organizationBiService;
        this.organizationBiRepository = organizationBiRepository;
    }

    //http://localhost:7070/oneToOne/organization/create
    @PostMapping("/createOrganization")
    public ResponseEntity<Object> createOrganization(@RequestBody OrganizationBi organization) {
        return organizationBiService.createOrganization(organization);
    }

    //http://localhost:7070/oneToOne/organization/get/{id}
    @GetMapping("/getOrganization/{id}")
    public OrganizationBi getOrganization(@PathVariable Long id) {
        if(organizationBiRepository.findById(id).isPresent())
            return organizationBiRepository.findById(id).get();
        else return null;
    }

    //http://localhost:7070/oneToOne/organization/getAllOrganization
    @GetMapping("/getOrganizations")
    public List<OrganizationBi> getOrganizations() {
        return organizationBiRepository.findAll();
    }

    //http://localhost:7070/oneToOne/organization/delete/{id}
    @DeleteMapping("/deleteOrganization/{id}")
    public ResponseEntity<Object> deleteOrganization(@PathVariable Long id) {
        if(organizationBiRepository.findById(id).isPresent()) {
            organizationBiRepository.deleteById(id);
            if (organizationBiRepository.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified organization");
            else return ResponseEntity.ok("Successfully deleted the specified organization");
        } else return ResponseEntity.unprocessableEntity().body("Specified organization not present");
    }
    //http://localhost:7070/oneToOne/organization/update/{id}
    @PutMapping("/updateOrganization/{id}")
    public ResponseEntity<Object> updateOrganization(@PathVariable Long id, @RequestBody OrganizationBi org) {
        return organizationBiService.updateOrganization(id, org);
    }
}
