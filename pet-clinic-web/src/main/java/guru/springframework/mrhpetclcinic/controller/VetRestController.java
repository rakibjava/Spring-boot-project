package guru.springframework.mrhpetclcinic.controller;

import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.service.VetServiceImp;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/vets")
public class VetRestController {
    private final VetService vetService;
    private final VetServiceImp vetServiceImp;

    public VetRestController(VetService vetService, VetServiceImp vetServiceImp) {
        this.vetService = vetService;
        this.vetServiceImp = vetServiceImp;
    }

    //http://localhost:7070//rest/vets//listOfAllVet/
    @RequestMapping({"/listOfAllVet"})
    public ResponseEntity<Set<Vet>> listVets() {
        return new ResponseEntity<>(vetService.findAll(), HttpStatus.OK);
    }

    //http://localhost:7070//rest/vets///findByVetId/{id}/
    @RequestMapping({"/findByVetId/{id}/"})
    public ResponseEntity<Vet> findVetId(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(vetService.findById(id),HttpStatus.OK);
    }

    //http://localhost:7070//rest/vets/addVetWithResponseEntity/
    @PostMapping("/addVetWithResponseEntity/")
    public ResponseEntity<Object> addVetWithResponseEntity(@RequestBody Vet vet) {
        return vetServiceImp.addVet(vet);
    }

    //http://localhost:7070//rest/vets/add/
    @PostMapping("/add/")
    public ResponseEntity<Vet> addVet(@RequestBody Vet vet){
        return new ResponseEntity<>(vetService.save(vet),HttpStatus.CREATED);
    }

    //http://localhost:7070/rest/vets/{vetId}/update/
    @PutMapping("/{vetId}/update/")
    public ResponseEntity<Vet> updateVet(@RequestBody Vet vet,@PathVariable (name = "vetId") Long vetId){
        return new ResponseEntity<>(vetServiceImp.updateVetSpecialty(vet,vetId), HttpStatus.OK);
    }
    //http://localhost:7070/rest/vets//{vetId}/delete/
    @DeleteMapping("/{vetId}/delete/")
    public ResponseEntity<?> deleteVetById (@PathVariable(name = "vetId") Long vetId){
        vetService.deleteById(vetId);
        return  ResponseEntity.ok().build();
    }
}
