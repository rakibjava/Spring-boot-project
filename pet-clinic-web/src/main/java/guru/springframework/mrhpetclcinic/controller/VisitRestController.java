package guru.springframework.mrhpetclcinic.controller;

import guru.springframework.mrhpetclcinic.model.Pet;
import guru.springframework.mrhpetclcinic.model.Visit;
import guru.springframework.mrhpetclcinic.service.serviceinterface.OwnerService;
import guru.springframework.mrhpetclcinic.service.serviceinterface.PetService;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VisitService;
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
    public Set<Visit> getAllVisit(){
        Set<Visit> visits = visitService.findAll();
        return visits;
    }

    // http://localhost:7070//pet/{petid}/visit/
    @PostMapping
    @RequestMapping("/{petid}/visit/")
    public Pet addVisit(@RequestBody Visit visit, @PathVariable(name = "petid") Long petid){
        Pet petByVisit = petService.findById(petid);
        visit.setPet(petByVisit);
        visitService.save(visit);
        //visit.setPet(petByVisit);
       // petByVisit.getVisits().add(visit);
        //petService.save(petByVisit);
        return petByVisit;
    }

}
