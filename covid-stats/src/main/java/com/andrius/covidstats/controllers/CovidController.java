package com.andrius.covidstats.controllers;

import com.andrius.covidstats.services.CovidService;
import com.andrius.covidstats.dtos.StatisticsDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("covid")
@AllArgsConstructor
public class CovidController {

    private final CovidService covidService;

    @GetMapping
    public StatisticsDto getStatisticsOfCountry(@NotNull @RequestParam String country){
        return covidService.getStatisticsOfCountry(country);
    }

    @GetMapping("countries")
    public Map<String, String> getCountries() {
        return covidService.getCountriesAndCodes();
    }
}
