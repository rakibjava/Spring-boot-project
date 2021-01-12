package guru.springframework.mrhpetclcinic.controller;


import guru.springframework.mrhpetclcinic.ManyToMany.VetM2M;
import guru.springframework.mrhpetclcinic.ManyToMany.VetM2mService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vet_specialty")
public class VetM2MRestController {

    private final VetM2mService vetM2mService;

    public VetM2MRestController(VetM2mService vetM2mService) {
        this.vetM2mService = vetM2mService;
    }

    //http://localhost:7070/vet_specialty/getAllVet/
    @GetMapping("/getAllVet/")
    public ResponseEntity<List<VetM2M>> getAllVet(){
        List<VetM2M> vetM2MS = vetM2mService.findAll();
        return new ResponseEntity<>(vetM2MS, HttpStatus.OK);
    }

    //http://localhost:7070/vet_specialty/getAllVetSortByLastName/
    @GetMapping("/getAllVetSortByLastName/")
    public ResponseEntity<List<VetM2M>> getAllVetByLastNameSorting(){
        List<VetM2M> vetM2MS = vetM2mService.findAllSortByLastName();
        return new ResponseEntity<>(vetM2MS,HttpStatus.OK);
    }

    //http://localhost:7070/vet_specialty/addVet/
    @PostMapping("/addVet/")
    public ResponseEntity<VetM2M> addVet(@RequestBody VetM2M vetM2M){
        VetM2M vetM2M1 = vetM2mService.save(vetM2M);
        return new ResponseEntity<>(vetM2M1,HttpStatus.CREATED);
    }

}
