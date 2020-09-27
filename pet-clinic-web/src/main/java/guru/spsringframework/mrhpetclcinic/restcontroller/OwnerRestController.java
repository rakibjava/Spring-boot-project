package guru.spsringframework.mrhpetclcinic.restcontroller;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/owners/")
public class OwnerRestController {
    private OwnerService ownerService;

    public OwnerRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping({"/listofAllOwner","/"})
    public Set<Owner> listOwners(){
        return ownerService.findAll();
    }
}
