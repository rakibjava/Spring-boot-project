package guru.springframework.mrhpetclcinic.onetoone.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationBiRepository extends JpaRepository<OrganizationBi,Long> {
}
