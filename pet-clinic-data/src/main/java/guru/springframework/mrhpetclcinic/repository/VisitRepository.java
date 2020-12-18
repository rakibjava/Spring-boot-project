package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
