package com.example.explorerio;

import com.example.explorerio.domain.model.Difficulty;
import com.example.explorerio.domain.model.Region;
import com.example.explorerio.domain.model.TourPackage;
import com.example.explorerio.domain.model.Trail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevTestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //Testing Trail and TrailPackages Models
        {
            TourPackage trailPem = new TourPackage("PEM", "Parque Estadual do Mendanha",80.0);

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
            System.out.println(t1.toString());}


    }
}
