package guru.springframework.mrhpetclcinic.model.ManyToMany;

import guru.springframework.mrhpetclcinic.model.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetM2mService {

   private VetM2mRepository  vetM2mRepository;
   private  SpecialtyM2MRepository  specialtyM2MRepository;

    public VetM2mService(VetM2mRepository vetM2mRepository, SpecialtyM2MRepository specialtyM2MRepository) {
        this.vetM2mRepository = vetM2mRepository;
        this.specialtyM2MRepository = specialtyM2MRepository;
    }

    public List<VetM2M> findAll() {
        return vetM2mRepository.findAll();
    }


    public List<VetM2M> findAllSortByLastName() {
        return vetM2mRepository.findAll(Sort.by(Sort.Direction.DESC,"lastName"));
    }


    public Page<VetM2M> findAll(Pageable pageable) {
        return null;
    }


    public List<VetM2M> findAllById(Iterable<Long> longs) {
        return null;
    }


    public long count() {
        return 0;
    }


    public void deleteById(Long aLong) {

    }


    public void delete(VetM2M entity) {

    }


    public void deleteAll(Iterable<? extends VetM2M> entities) {

    }


    public void deleteAll() {

    }


    public <S extends VetM2M> VetM2M save(VetM2M entity) {
        VetM2M vetM2M = vetM2mRepository.save(entity);
        return vetM2M;
    }


    public <S extends VetM2M> List<S> saveAll(Iterable<S> entities) {
        return null;
    }


    public Optional<VetM2M> findById(Long aLong) {
        return Optional.empty();
    }


    public boolean existsById(Long aLong) {
        return false;
    }


    public void flush() {

    }


    public <S extends VetM2M> S saveAndFlush(S entity) {
        return null;
    }


    public void deleteInBatch(Iterable<VetM2M> entities) {

    }


    public void deleteAllInBatch() {

    }


    public VetM2M getOne(Long aLong) {
        return null;
    }


    public <S extends VetM2M> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }


    public <S extends VetM2M> List<S> findAll(Example<S> example) {
        return null;
    }


    public <S extends VetM2M> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }


    public <S extends VetM2M> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }


    public <S extends VetM2M> long count(Example<S> example) {
        return 0;
    }


    public <S extends VetM2M> boolean exists(Example<S> example) {
        return false;
    }
}
