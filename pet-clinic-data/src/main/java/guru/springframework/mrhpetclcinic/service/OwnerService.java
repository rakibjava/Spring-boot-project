package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Owner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
