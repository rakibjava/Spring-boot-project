package guru.springframework.mrhpetclcinic.controller;

import guru.springframework.mrhpetclcinic.model.Specialty;
import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/vets")
public class VetRestController {
    private final VetService vetService;

    public VetRestController(VetService vetService) {
        this.vetService = vetService;
    }

    //http://localhost:7070//rest/vets//listOfAllVet/
    @RequestMapping({"/listOfAllVet",""})
    public Set<Vet> listVets(){
        return vetService.findAll();
    }

    //http://localhost:7070//rest/vets//add/
    @PostMapping("/add/")
    public Vet addVet(@RequestBody Vet vet){
        Vet vet1 = new Vet();
        vet1.setFirstName(vet.getFirstName());
        vet1.setLastName(vet.getLastName());
        vet.getSpecialities().forEach(vet1.getSpecialities()::add);
        return  vetService.save(vet1);
    }
    //http://localhost:7070/rest/vets/{vetId}/update/
    @PutMapping("/{vetId}/update/")
    public Vet updateVet(@RequestBody Vet vet,@PathVariable (name = "vetId") Long vetId){
        Vet vet1 = vetService.findById(vetId);
        vet1.setFirstName(vet.getFirstName());
        vet1.setLastName(vet.getLastName());
       // Set<Specialty> specialties = vet.getSpecialities();
        vet1.getSpecialities().clear();
        vet1.setSpecialities(vet.getSpecialities());
        return  vetService.save(vet1);
    }

    //http://localhost:7070/rest/vets//{vetId}/delete/
    @DeleteMapping("/{vetId}/delete/")
    public ResponseEntity<?> deleteVetById (@PathVariable(name = "vetId") Long vetId){
        vetService.deleteById(vetId);
        return  ResponseEntity.ok().build();
    }
}
