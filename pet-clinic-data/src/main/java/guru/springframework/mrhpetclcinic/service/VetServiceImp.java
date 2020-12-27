package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.repository.VetRepository;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VetServiceImp implements VetService {
    private final VetRepository vetRepository;

    public VetServiceImp(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Vet vet;
        if(vetRepository.findById(aLong).isPresent()){
            vet = vetRepository.findById(aLong).get();
            return vet;
        }
        //vetRepository.findById(aLong).orElse(null)
        return null;
    }

    @Override
    public Vet save(Vet vet) {
        if(vetRepository.findByLastName(vet.getLastName()).isPresent()){
            return  null;
        }
        Vet vet1 = new Vet();
        vet1.setFirstName(vet.getFirstName());
        vet1.setLastName(vet.getLastName());
        //vet.getSpecialities().forEach(vet1.getSpecialities()::add);
        vet1.setSpecialities(vet.getSpecialities());
        Vet vetSaved = vetRepository.save(vet1);
        return vetSaved;
    }
    //using ResponseEntity to add vet
    public ResponseEntity<Object> addVet(Vet vet) {
        if(vetRepository.findByLastName(vet.getLastName()).isPresent()){
            return  ResponseEntity.badRequest().body("Vet Already in the database");
        }
        Vet vet1 = new Vet();
        vet1.setFirstName(vet.getFirstName());
        vet1.setLastName(vet.getLastName());
        vet1.setSpecialities(vet.getSpecialities());
        Vet vetSaved = vetRepository.save(vet1);
        return ResponseEntity.ok(vetSaved);
    }

    public Vet updateVetSpecialty(Vet vet, Long vetId){
        if(vetRepository.findById(vetId).isPresent()){
            Vet vetToUpdate = vetRepository.findById(vetId).get();
            vetToUpdate.setFirstName(vet.getFirstName());
            vetToUpdate.setLastName(vet.getLastName());
            // Set<Specialty> specialties = vet.getSpecialities();
            // vet1.getSpecialities().clear();
            vetToUpdate.setSpecialities(vet.getSpecialities());
            return vetRepository.save(vetToUpdate);
        }
        return null;
    }
    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
