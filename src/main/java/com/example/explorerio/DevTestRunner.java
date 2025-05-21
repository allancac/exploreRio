package com.example.explorerio;

import com.example.explorerio.application.service.TourPackageService;
import com.example.explorerio.application.service.TrailService;
import com.example.explorerio.domain.model.Difficulty;
import com.example.explorerio.domain.model.Region;
import com.example.explorerio.domain.model.TourPackage;
import com.example.explorerio.domain.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("dev")
@Component
public class DevTestRunner implements CommandLineRunner {
    @Autowired
    private TourPackageService tourPackageService;
    @Autowired
    private TrailService trailService;

    @Override
    public void run(String... args) throws Exception {
        //Testing Trail and TrailPackages Models
        {/*TourPackage trailPem = new TourPackage("PEM", "Parque Estadual do Mendanha",80.0);

            Trail t1 = new Trail(
                    "Cachoeira do Mendanha",
                    "Cachoeira localizada no Parque Estadual do Mendanha, com várias quedas de água com piscinas naturais e uma trilha com uma bela vista da mata atlântica.",
                    "piscina, floresta, cachoeira, parque, mendanha",
                    5,
                    4.5,
                    Difficulty.findByLevel(2),
                    Region.findByLabel("west"),
                    trailPem
            );
            System.out.println(t1.toString());*/}

        //Testing Tour Package Service
        {tourPackageService.createTourPackage("RJPEM1", "Circuito Cachoeiras Parque Estadual do Mendanha", 80.0);
            tourPackageService.createTourPackage("RJPEM2", "Circuito Completo Cachoeiras Parque Estadual do Mendanha", 120.0);
            var myTtours = tourPackageService.getAllTourPackages();
            myTtours.forEach(System.out::println);

            var tour1 = tourPackageService.getTourPackageByCode("RJPEM11");
            System.out.println("Resultado da busca: \n"+
                    (tour1.isPresent() ? tour1.get().toString() : "Tour não encontrado."));}

        //Testing Trail Service
        {trailService.createTrail(
                    "Cachoeira do Mendanha",
                    "Cachoeira localizada no Parque Estadual do Mendanha, com várias quedas de água com piscinas naturais e uma trilha com uma bela vista da mata atlântica.",
                    "piscina, floresta, cachoeira, parque, mendanha",4,2.0,"medium","west","RJPEM2");

            trailService.createTrail("Circuito cachoeiras do Mendanha",
                    "Trilha localizada no Parque Estadual do Mendanha, que explora todas cascatas e lagos naturais.",
                    "cascata, floresta, cachoeira, parque, mendanha",9,5.5,"difficult","west","RJPEM1");

            List<Trail> myTrails = trailService.getAllTrails();
            myTrails.forEach(System.out::println);
            System.out.println("*".repeat(80) + "\n");

            trailService.updateTrail(2L,"Circuito cachoeiras do Mendanha",
                    "Trilha que atravessa o Parque Estadual do Mendanha e a Serra de Madureira, explorando todas cascatas e lagos naturais.",
                    "cascata, floresta, cachoeira, parque, mendanha",9,5.5,"difficult","west","RJPEM1");
            myTrails = trailService.getAllTrails();
            myTrails.forEach(System.out::println);
            System.out.println("*".repeat(80) + "\n");

            trailService.deleteTrail(1L);
            myTrails = trailService.getAllTrails();
            myTrails.forEach(System.out::println);
            System.out.println("*".repeat(80) + "\n");
        }



    }
}
