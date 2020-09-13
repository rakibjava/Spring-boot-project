package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save (Vet vet);
    Set<Vet> findAll();
}
