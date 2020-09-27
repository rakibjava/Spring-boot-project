package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Pet;
import org.springframework.stereotype.Component;


public interface PetService extends CrudService<Pet,Long> {
}
