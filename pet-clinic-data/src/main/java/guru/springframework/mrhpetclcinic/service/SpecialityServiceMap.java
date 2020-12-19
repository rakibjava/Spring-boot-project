package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Specialty;
import guru.springframework.mrhpetclcinic.repository.SpecialityRepository;
import guru.springframework.mrhpetclcinic.service.serviceinterface.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpecialityServiceMap implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialityServiceMap(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> vetSpeciality= new HashSet<>();
        specialityRepository.findAll().forEach(vetSpeciality::add);
        return vetSpeciality;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
