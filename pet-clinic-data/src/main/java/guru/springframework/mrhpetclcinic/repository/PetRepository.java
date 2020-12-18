package guru.springframework.mrhpetclcinic.repository;

import guru.springframework.mrhpetclcinic.model.Pet;
import guru.springframework.mrhpetclcinic.model.PetType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet,Long> {

    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<PetType> findPetTypes();

    /**
     * Retrieve a {@link Pet} from the data store by id.
     * @param id the id to search for
     * @return the {@link Pet} if found
     */
    @Transactional(readOnly = true)
    Pet findById(Integer id);

    /**
     * Save a {@link Pet} to the data store, either inserting or updating it.
     * @param pet the {@link Pet} to save
     */
    //void save(Pet pet);
}
