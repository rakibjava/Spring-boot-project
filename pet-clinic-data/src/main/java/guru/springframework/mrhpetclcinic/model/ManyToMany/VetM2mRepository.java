package guru.springframework.mrhpetclcinic.model.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetM2mRepository extends JpaRepository<VetM2M,Long> {
}
