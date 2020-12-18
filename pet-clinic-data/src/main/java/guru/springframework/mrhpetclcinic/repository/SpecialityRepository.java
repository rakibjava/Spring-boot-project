package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
