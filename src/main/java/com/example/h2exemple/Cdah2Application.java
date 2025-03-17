package com.example.h2exemple;

import com.adrar.cdah2.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cdah2Application implements CommandLineRunner {
    @Autowired
    private LivreService livreService;
    public static void main(String[] args) {
        SpringApplication.run(Cdah2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(livreService.getClass());
    }
}
