package guru.springframework.mrhpetclcinic.service.serviceinterface;

import guru.springframework.mrhpetclcinic.model.Owner;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
    Owner findByIdUsingCustomQuery(Long id);
    Collection<Owner> findByLastNameUsingCustomQuery(String lastName);
}
