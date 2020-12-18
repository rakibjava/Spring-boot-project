package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.service.serviceinterface.OwnerService;
import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.repository.OwnerRepository;
import guru.springframework.mrhpetclcinic.repository.PetRepository;
import guru.springframework.mrhpetclcinic.repository.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository,
                            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findByIdUsingCustomQuery(Long id) {
        return ownerRepository.findByIdWithCustom(id);
    }

    @Override
    public Collection<Owner> findByLastNameUsingCustomQuery(String lastName) {
        return ownerRepository.findByLastNameUsingCustom(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
