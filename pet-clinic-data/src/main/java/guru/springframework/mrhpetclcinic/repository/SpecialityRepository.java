package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Specialty,Long> {
}
