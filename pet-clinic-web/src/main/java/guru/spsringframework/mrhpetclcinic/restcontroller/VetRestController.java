package guru.spsringframework.mrhpetclcinic.restcontroller;

import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.service.VetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/rest/vets")
public class VetRestController {
    private final VetService vetService;

    public VetRestController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/listOfAllVet",""})
    public Set<Vet> listVets(){
        return vetService.findAll();
    }
}
