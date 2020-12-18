package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.PetType;
import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.repository.PetTypeRepository;
import guru.springframework.mrhpetclcinic.service.serviceinterface.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PetTypeServiceImpl implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petType = new HashSet<>();
        petTypeRepository.findAll().forEach(petType::add);
        return petType;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
