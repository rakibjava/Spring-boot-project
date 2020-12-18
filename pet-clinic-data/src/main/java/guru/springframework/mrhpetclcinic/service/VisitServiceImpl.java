package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Pet;
import guru.springframework.mrhpetclcinic.model.Visit;
import guru.springframework.mrhpetclcinic.repository.VisitRepository;
import guru.springframework.mrhpetclcinic.service.serviceinterface.VisitService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits= new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
