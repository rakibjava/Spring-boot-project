package guru.springframework.mrhpetclcinic.restcontroller;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.service.serviceinterface.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/rest/")
public class OwnerRestController {
    private OwnerService ownerService;

    public OwnerRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    // findallOwners
    // http://localhost:7070/rest/owners
    @GetMapping("/owners")
    @ResponseBody
    public Set<Owner> listOwners(){
        Set<Owner> owners = ownerService.findAll();
        return owners;
    }
    // findbyLastName using queryParam
    // http://localhost:7070/rest/findByLastNameUsingQueryParam/?lastName=Gleanne
    @GetMapping("/findByLastNameUsingQueryParam")
    @ResponseBody
    public Owner findOwnerByLastNameUsingQueryParam(@RequestParam(name = "lastName") String lastName){
        return ownerService.findByLastName(lastName);
    }
    // findbyLastName using pathVariable
    // http://localhost:7070/rest/findByLastNameUsingPathVariable/Gleanne
    @GetMapping("/findByLastNameUsingPathVariable/{lastName}")
    @ResponseBody
    public Owner findOwnerByLastNameUsingPathVariable(@PathVariable(name = "lastName") String lastName){
        return ownerService.findByLastName(lastName);
    }

    // findbyLastName using pathVariable
    // http://localhost:7070/rest/findByLastNameUsingCustomQuery/Gleanne
    @GetMapping("/findByLastNameUsingCustomQuery/{lastName}")
    @ResponseBody
    public Collection<Owner> findOwnerByLastNameUsingCustomQuery(@PathVariable(name = "lastName") String lastName){
        return ownerService.findByLastNameUsingCustomQuery(lastName);
    }

    // findbyid using queryParam
    // http://localhost:7070/rest/findByIdUsingQueryParam/?id=1
    @GetMapping("/findByIdUsingQueryParam/")
    public Owner findOwnerByIdUsingQueryParam(@RequestParam(name = "id") Long id){
        return ownerService.findById(id);
    }

    // findbyid using pathvariable
    // http://localhost:7070/rest/findByIdUsingPathVariable/1
    @GetMapping("/findByIdUsingPathVariable/{id}")
    public Owner findOwnerByIdUsingPathVariable(@PathVariable(name = "id") Long id){
        return ownerService.findById(id);
    }

    // findbyid using pathvariable
    // http://localhost:7070/rest/findByIdUsingCustomQuery/1
    @GetMapping("/findByIdUsingCustomQuery/{id}")
    public Owner findOwnerByIdUsingfindByIdUsingCustomQuery(@PathVariable(name = "id") Long id){
        Owner owner = ownerService.findByIdUsingCustomQuery(id);
        return owner;
    }

    // add owner
    //http://localhost:7070/rest//add/owner/
    @PostMapping("/add/owner/")
    public Owner addOwners(@RequestBody Owner owner){
        Owner ownerToSaved = ownerService.save(owner);
        return ownerService.findById(ownerToSaved.getId());
    }

    // edit or update owner
    //http://localhost:7070/rest/edit/owner/1
    @PutMapping("/edit/owner/{ownerid}")
    public Owner updateOwner(@RequestBody Owner owner, @PathVariable(name = "ownerid") Long ownerid){
        Owner requestOwner = ownerService.findById(ownerid);
        requestOwner.setFirstName(owner.getFirstName());
        requestOwner.setLastName(owner.getLastName());
        requestOwner.setCity(owner.getCity());
        requestOwner.setAddress(owner.getAddress());
        requestOwner.setTelephone(owner.getTelephone());
        Owner updatedOwner = ownerService.save(requestOwner);
        return updatedOwner;
    }

    //http://localhost:7070/rest//owners/delete/{ownerid}/
    @DeleteMapping("/owners/delete/{ownerid}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable(name = "ownerid") Long ownerid){
        ownerService.deleteById(ownerid);
        return ResponseEntity.ok().build();
    }
}
