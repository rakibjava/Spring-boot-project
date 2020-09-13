package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save (Pet pet);
    Set<Pet> findAll();
}
