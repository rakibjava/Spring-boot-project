package guru.springframework.mrhpetclcinic.bootstrap;


import guru.springframework.mrhpetclcinic.model.*;
import guru.springframework.mrhpetclcinic.model.ManyToMany.*;
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


    private final VetM2mService vetM2mService;
    private final SpecialtyM2mService specialtyM2mService;

    //private  final Sp specialtyM2MRepository;

    public DataLoaderSDJPA(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialityService specialityService, VisitService visitService, PetService petService,
                           VetM2mService vetM2mService, SpecialtyM2mService specialtyM2mService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;

        this.vetM2mService = vetM2mService;
        this.specialtyM2mService = specialtyM2mService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count= petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {

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


        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");

        //no need save vet will save specialties because in vet define cascade type persist and merge
        //Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        //no need save vet will save specialties because in vet define cascade type persist and merge
        //Specialty savedSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        //no need save vet will save specialties because in vet define cascade type persist and merge
        //Specialty savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        vet1.getSpecialities().add(dentistry);
        //vet1.getSpecialities().add(surgery);
        vetService.save(vet1);
        System.out.println("Vet1 Loaded............"+vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessi");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Vet2 Loaded............"+vet2);


        SpecialtyM2M specialtyM2MVet1 = new SpecialtyM2M();
        specialtyM2MVet1.setDescription("cat_specialist");

        SpecialtyM2M specialtyM2MVet2 = new SpecialtyM2M();
        specialtyM2MVet2.setDescription("Bird_specialist");

        SpecialtyM2M specialtyM2MVet3 = new SpecialtyM2M();
        specialtyM2MVet3.setDescription("Dog_specialist");


        VetM2M vetM2MSpecialty1 = new VetM2M();
        vetM2MSpecialty1.setFirstName("Sam1");
        vetM2MSpecialty1.setLastName("Axe1");
        vetM2MSpecialty1.addSpeciality(specialtyM2MVet1);
        vetM2MSpecialty1.addSpeciality(specialtyM2MVet2);


        //specialtyM2MVet1.getVetM2MSpecialties().add(vetM2MSpecialty1);
        //specialtyM2MVet2.getVetM2MSpecialties().add(vetM2MSpecialty1);

        vetM2mService.save(vetM2MSpecialty1);

        System.out.println("VetM2MSpecialty1 Loaded............"+vetM2MSpecialty1);

        VetM2M vetM2MSpecialty2 = new VetM2M();
        vetM2MSpecialty2.setFirstName("Jessi1");
        vetM2MSpecialty2.setLastName("Porter1");

        vetM2MSpecialty2.addSpeciality(specialtyM2MVet3);


        //specialtyM2MVet1.getVetM2MSpecialties().add(specialtyM2MVet3);
        //specialtyM2MVet2.getVetM2MSpecialties().add(vetM2MSpecialty2);

       // specialtyM2MVet3.getVetM2MSpecialties().add(vetM2MSpecialty2);

        vetM2mService.save(vetM2MSpecialty2);

        specialtyM2MVet3.getVetM2MSpecialties().add(vetM2MSpecialty1);
        specialtyM2MVet3.getVetM2MSpecialties().add(vetM2MSpecialty2);
        specialtyM2mService.save(specialtyM2MVet3);

        System.out.println("vetM2MSpecialty2 Loaded............"+vetM2MSpecialty2);
    }
}
