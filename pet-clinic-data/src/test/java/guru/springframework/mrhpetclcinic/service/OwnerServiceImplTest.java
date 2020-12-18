package guru.springframework.mrhpetclcinic.service;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.repository.OwnerRepository;
import guru.springframework.mrhpetclcinic.repository.PetRepository;
import guru.springframework.mrhpetclcinic.repository.PetTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {
    public static final String LAST_NAME = "Smith";
    @Mock
     OwnerRepository ownerRepository;
    @Mock
     PetRepository petRepository;
    @Mock
     PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerServiceImpl ownerService;

    Owner returnOwner = new Owner();

     @BeforeEach
    void setUp() {
         returnOwner.setId(1L);
         returnOwner.setLastName(LAST_NAME);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner= ownerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,owner.getLastName());
        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Owner retunOwner = new Owner();
        retunOwner.setId(1L);
        Owner retunOwner1 = new Owner();
        retunOwner.setId(2L);
        Set<Owner> returOwnerSet = new HashSet<>();
        returOwnerSet.add(retunOwner);
        returOwnerSet.add(retunOwner1);
        when(ownerRepository.findAll()).thenReturn(returOwnerSet);
        Set<Owner> owners = ownerService.findAll();
        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {
         when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
         Owner owner = ownerService.findById(1L);
         assertNotNull(owner);
    }

    @Test
    void save() {
         Owner ownerToSave = new Owner();
         ownerToSave.setId(1L);
         when(ownerRepository.save(any())).thenReturn(returnOwner);
         Owner savedOwner = ownerService.save(ownerToSave);
         assertNotNull(savedOwner);
         verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
         ownerService.delete(returnOwner);
         verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
         ownerService.deleteById(1L);
         verify(ownerRepository).deleteById(anyLong());
    }
}