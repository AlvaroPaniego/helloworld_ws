package com.alvaropaniego.helloworld_ws.controller;

import com.alvaropaniego.helloworld_ws.model.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaludoController {
    private static  final  String template = "Hola, %s!";
    private final static AtomicLong along = new AtomicLong();
    @GetMapping("/saludo")
    public Saludo saludar(@RequestParam(value = "nombre", defaultValue = "a todos") String name){
        return new Saludo(along.incrementAndGet(), String.format(template, name));
    }
}
