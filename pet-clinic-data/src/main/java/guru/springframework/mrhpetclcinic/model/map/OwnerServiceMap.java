package guru.springframework.mrhpetclcinic.model.map;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.service.CrudService;
import guru.springframework.mrhpetclcinic.service.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return this.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
