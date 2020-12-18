package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
