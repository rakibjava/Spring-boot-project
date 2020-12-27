package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VetRepository extends JpaRepository<Vet,Long> {

    Optional<Vet> findByLastName(String lastName);
}
