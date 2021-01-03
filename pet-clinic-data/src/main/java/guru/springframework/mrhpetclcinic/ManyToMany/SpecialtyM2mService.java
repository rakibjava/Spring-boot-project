package guru.springframework.mrhpetclcinic.ManyToMany;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyM2mService implements CrudRepository<SpecialtyM2M,Long> {

    @Override
    public <S extends SpecialtyM2M> S save(S entity) {
        return null;
    }

    @Override
    public <S extends SpecialtyM2M> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<SpecialtyM2M> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<SpecialtyM2M> findAll() {
        return null;
    }

    @Override
    public Iterable<SpecialtyM2M> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(SpecialtyM2M entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends SpecialtyM2M> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
