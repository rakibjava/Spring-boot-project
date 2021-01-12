package guru.springframework.mrhpetclcinic.controller;

import guru.springframework.mrhpetclcinic.exception.handling.ExceptionReason;
import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.service.OwnerServiceImpl;
import guru.springframework.mrhpetclcinic.service.serviceinterface.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/rest/")
public class OwnerRestController {
    private OwnerService ownerService;
    private OwnerServiceImpl ownerServiceImp;

    public OwnerRestController(OwnerService ownerService,OwnerServiceImpl ownerServiceImp) {
        this.ownerService = ownerService;
        this.ownerServiceImp = ownerServiceImp;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    // findallOwners
    // http://localhost:7070/rest/owners
    @GetMapping("/owners")
    @ResponseBody
    public ResponseEntity<Set<Owner>>listAllOwners(){
        Set<Owner> owners = ownerService.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }
    // findbyLastName using queryParam
    // http://localhost:7070/rest/findByLastNameUsingQueryParam/?lastName=Gleanne
    @GetMapping("/findByLastNameUsingQueryParam")
    @ResponseBody
    public ResponseEntity<Owner> findOwnerByLastNameUsingQueryParam(@RequestParam(name = "lastName") String lastName){
        Owner owner = ownerService.findByLastName(lastName);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    // findbyLastName using pathVariable
    // http://localhost:7070/rest/findByLastNameUsingPathVariable/Gleanne
    @GetMapping("/findByLastNameUsingPathVariable/{lastName}")
    @ResponseBody
    public ResponseEntity<Owner> findOwnerByLastNameUsingPathVariable(@PathVariable(name = "lastName") String lastName){
        Owner owner = ownerService.findByLastName(lastName);
        if(owner == null){
            throw new ExceptionReason("There is no owner with lastName:"+ lastName);
        }
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    // findbyLastName using pathVariable
    // http://localhost:7070/rest/findByLastNameUsingCustomQuery/Gleanne
    @GetMapping("/findByLastNameUsingCustomQuery/{lastName}")
    @ResponseBody
    public ResponseEntity<Collection<Owner>> findOwnerByLastNameUsingCustomQuery(
            @PathVariable(name = "lastName") String lastName){
        Collection<Owner> owner = ownerService.findByLastNameUsingCustomQuery(lastName);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    // findbyid using queryParam
    // http://localhost:7070/rest/findByIdUsingQueryParam/?id=1
    @GetMapping("/findByIdUsingQueryParam/")
    public ResponseEntity<Owner> findOwnerByIdUsingQueryParam(@RequestParam(name = "id") Long id){
        return new ResponseEntity<>(ownerService.findById(id),HttpStatus.OK);
    }

    // findbyid using pathvariable
    // http://localhost:7070/rest/findByIdUsingPathVariable/1
    @GetMapping("/findByIdUsingPathVariable/{id}")
    public ResponseEntity<Owner> findOwnerByIdUsingPathVariable(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(ownerService.findById(id),HttpStatus.OK);
    }

    // findbyid using pathvariable
    // http://localhost:7070/rest/findByIdUsingCustomQuery/1
    @GetMapping("/findByIdUsingCustomQuery/{id}")
    public ResponseEntity<Owner> findOwnerByIdUsingfindByIdUsingCustomQuery(@PathVariable(name = "id") Long id){
        Owner owner = ownerService.findByIdUsingCustomQuery(id);
        return new ResponseEntity<>(owner,HttpStatus.OK);
    }

    // add owner
    //http://localhost:7070/rest//add/owner/
    @PostMapping("/add/owner/")
    public ResponseEntity<Owner> addOwners(@RequestBody Owner owner){
        Owner ownerToSaved = ownerService.save(owner);
        return new ResponseEntity<>(ownerService.findById(ownerToSaved.getId()),HttpStatus.CREATED);
    }

    // edit or update owner
    //http://localhost:7070/rest/edit/owner/1
    @PutMapping("/edit/owner/{ownerid}")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner, @PathVariable(name = "ownerid") Long ownerid){
        Owner requestOwner = ownerService.findById(ownerid);
        requestOwner.setFirstName(owner.getFirstName());
        requestOwner.setLastName(owner.getLastName());
        requestOwner.setCity(owner.getCity());
        requestOwner.setAddress(owner.getAddress());
        requestOwner.setTelephone(owner.getTelephone());
        Owner updatedOwner = ownerService.save(requestOwner);
        return new ResponseEntity<>(ownerService.findById(updatedOwner.getId()),HttpStatus.ACCEPTED);
    }

    //http://localhost:7070/rest//owners/delete/{ownerid}/
    @DeleteMapping("/owners/delete/{ownerid}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable(name = "ownerid") Long ownerid){
        ownerService.deleteById(ownerid);
        return ResponseEntity.ok().build();
    }
}
