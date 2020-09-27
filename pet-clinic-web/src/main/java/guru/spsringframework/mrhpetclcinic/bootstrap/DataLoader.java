package guru.spsringframework.mrhpetclcinic.bootstrap;

import guru.springframework.mrhpetclcinic.model.Owner;
import guru.springframework.mrhpetclcinic.model.Vet;
import guru.springframework.mrhpetclcinic.model.map.OwnerServiceMap;
import guru.springframework.mrhpetclcinic.model.map.VetServiceMap;
import guru.springframework.mrhpetclcinic.service.OwnerService;
import guru.springframework.mrhpetclcinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        ownerService.save(owner2);
        System.out.println("Owners Loaded............");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Jessi");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Vet Loaded............");


    }
}
