package guru.springframework.mrhpetclcinic.model.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyM2MRepository extends CrudRepository<SpecialtyM2M,Long> {
}
