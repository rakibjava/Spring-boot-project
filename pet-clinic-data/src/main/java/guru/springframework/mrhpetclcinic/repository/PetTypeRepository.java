package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository  extends CrudRepository<PetType,Long> {
}
