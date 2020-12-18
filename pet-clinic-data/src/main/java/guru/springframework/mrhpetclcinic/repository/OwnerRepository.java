package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);

    @Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
    @Transactional(readOnly = true)
    Owner findByIdWithCustom(@Param("id") Long id);

    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastNameUsingCustom(@Param("lastName") String lastName);
}
