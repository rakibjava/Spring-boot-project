package guru.springframework.mrhpetclcinic.ManyToMany;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyM2MRepository extends CrudRepository<SpecialtyM2M,Long> {
}
