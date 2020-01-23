package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.dto.CervejaDto;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.cervejaria.dto.Tipo.ALE;
import static br.com.fiap.cervejaria.dto.Tipo.PILSEN;

@RestController
public class CervejaController {

    private List<CervejaDto> cervejaDtoList;

    public CervejaController(){
        cervejaDtoList = new ArrayList<>();

        cervejaDtoList.add(new CervejaDto(1,
                "Marca 1",
                4.5,
                PILSEN,
                BigDecimal.valueOf(12.9),
                ZonedDateTime.now().minusYears(3)));

        cervejaDtoList.add(new CervejaDto(1,
                "Marca 2",
                3.5,
                ALE,
                BigDecimal.valueOf(10.9),
                ZonedDateTime.now().minusYears(1)));
    }

    @GetMapping
    public List<CervejaDto> getAll(){
        return cervejaDtoList;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
