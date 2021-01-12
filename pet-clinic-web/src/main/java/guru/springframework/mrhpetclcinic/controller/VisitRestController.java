package guru.springframework.mrhpetclcinic.controller;

import guru.springframework.mrhpetclcinic.model.Pet;
import guru.springframework.mrhpetclcinic.model.Visit;
import guru.springframework.mrhpetclcinic.service.serviceinterface.OwnerService;
import guru.springframework.mrhpetclcinic.service.serviceinterface.PetService;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pet")
public class VisitRestController {
    public PetService petService;
    public VisitService visitService;
    public OwnerService ownerService;

    public VisitRestController(PetService petService, VisitService visitService,OwnerService ownerService) {
        this.petService = petService;
        this.visitService = visitService;
        this.ownerService = ownerService;
    }

    // http://localhost:7070//pet/visit/
    @GetMapping
    @RequestMapping("/visit")
    public ResponseEntity<Set<Visit>> getAllVisit(){
        Set<Visit> visits = visitService.findAll();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    // http://localhost:7070//pet/{petid}/visit/
    @PostMapping
    @RequestMapping("/{petId}/visit/")
    public ResponseEntity<Pet> addVisit(@RequestBody Visit visit, @PathVariable(name = "petId") Long petId){
        Pet petByVisit = petService.findById(petId);
        visit.setPet(petByVisit);
        visitService.save(visit);
        //visit.setPet(petByVisit);
       // petByVisit.getVisits().add(visit);
        //petService.save(petByVisit);
        return new ResponseEntity<>(petByVisit,HttpStatus.CREATED);
    }

    // http://localhost:7070//pet//{petId}/visit/{visitId}/
    @PutMapping
    @RequestMapping("/{petId}/visit/{visitId}/")
    public ResponseEntity<Pet> updateVisit (@PathVariable(name = "petId") Long petId,
                                            @PathVariable(name = "visitId") Long visitId,@RequestBody Visit visit){
        Pet pet = petService.findById(petId);
        Visit visit1 = visitService.findById(visitId);
        visit1.setDescription(visit.getDescription());
        visit1.setDate(visit.getDate());
        visitService.save(visit1);
        visit1.setPet(pet);
        return  new ResponseEntity<>(pet,HttpStatus.OK);
    }

    // http://localhost:7070//pet/visit/delete/{visitId}/
    @DeleteMapping
    @RequestMapping("/visit/delete/{visitId}/")
    public ResponseEntity<?> deleteVisit (@PathVariable(name = "visitId") Long visitId){
        visitService.deleteById(visitId);
        return  ResponseEntity.ok().build();
    }


}
