package guru.springframework.mrhpetclcinic.bootstrap;


import guru.springframework.mrhpetclcinic.model.*;
import guru.springframework.mrhpetclcinic.service.serviceinterface.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoaderSDJPA implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoaderSDJPA(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count= petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {


        /**/

        /*Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedradiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedsurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality saveddentistry = specialityService.save(dentistry);*/

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        owner1.setAddress("addressOwenr1");
        owner1.setCity("owner1City");
        owner1.setTelephone("owener1TelephoneNumer");

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogType = petTypeService.save(dog);

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("dog Visit");
        dogVisit.setPet(mikesPet);
        mikesPet.getVisits().add(dogVisit);
        //visitService.save(dogVisit);
       // petService.save(mikesPet);
        ownerService.save(owner1);

        System.out.println("Owners-1 Loaded............"+owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("addressOwenr2");
        owner2.setCity("owner2City");
        owner2.setTelephone("owener2TelephoneNumer");

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Just cat");
        owner2Pet.setPetType(saveCatPetType);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2.getPets().add(owner2Pet);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("cat Visit");
        catVisit.setPet(owner2Pet);
        owner2Pet.getVisits().add(catVisit);

        ownerService.save(owner2);
        System.out.println("Owners-2 Loaded............"+owner2);


        /*Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedradiology);
        vetService.save(vet1);
        System.out.println("Vet1 Loaded............"+vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessi");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedsurgery);
        vetService.save(vet2);

        System.out.println("Vet2 Loaded............"+vet2);*/
    }
}
