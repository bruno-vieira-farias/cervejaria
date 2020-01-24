package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.dto.CervejaDto;
import br.com.fiap.cervejaria.dto.CreateCervejaDto;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.dto.Tipo.ALE;
import static br.com.fiap.cervejaria.dto.Tipo.PILSEN;

@RestController
@RequestMapping("cervejas")
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

        cervejaDtoList.add(new CervejaDto(2,
                "Marca 2",
                3.5,
                ALE,
                BigDecimal.valueOf(10.9),
                ZonedDateTime.now().minusYears(1)));
    }

    @GetMapping
    public List<CervejaDto> getAll(@RequestParam(required = false) Tipo tipo){
        return cervejaDtoList.stream()
                .filter(it -> tipo == null || it.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CervejaDto findById(@PathVariable Integer id){
        return cervejaDtoList.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public CervejaDto create(@RequestBody CreateCervejaDto createCervejaDto){
        CervejaDto cervejaDto = new CervejaDto(createCervejaDto, cervejaDtoList.size() + 1);
        cervejaDtoList.add(cervejaDto);
        return cervejaDto;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
