package guru.springframework.mrhpetclcinic.onetoone.bidirectional.mappedByInChildSide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBiRepository extends JpaRepository<AddressBi,Long> {
}
