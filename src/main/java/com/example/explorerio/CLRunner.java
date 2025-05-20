package com.example.explorerio;

import com.example.explorerio.domain.model.Difficulty;
import com.example.explorerio.domain.model.Region;
import com.example.explorerio.domain.model.Trail;
import com.example.explorerio.domain.model.TrailPackage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //Testing Trail and TrailPackages Models
        {TrailPackage trailPem = new TrailPackage("PEM", "Parque Estadual do Mendanha");

            Trail t1 = new Trail(
                    "Cachoeira do Mendanha",
                    "Cachoeira localizada no Parque Estadual do Mendanha, com várias quedas de água com piscinas naturais e uma trilha com uma bela vista da mata atlântica.",
                    "piscina, floresta, cachoeira, parque, mendanha",
                    5,
                    4.5,
                    Difficulty.valueOf("medium".toUpperCase()),
                    Region.valueOf("north".toUpperCase()),
                    trailPem
            );
            System.out.println(t1.toString());}


    }
}
