package com.example.Ejercicio1_Sesion6.controller;

import com.example.Ejercicio1_Sesion6.entity.Laptop;
import com.example.Ejercicio1_Sesion6.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository=laptopRepository;
    }
    @GetMapping("/api/laptop")
    public List<Laptop> findAll(@RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop,@RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }

}
