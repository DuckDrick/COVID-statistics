package com.andrius.covidstats.repositories;

import com.andrius.covidstats.entities.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    public static List<Data> data;

    public static List<Data> getDataOfCountry (String country) {
        return data.stream().filter(data -> data.getCountry().equals(country)).collect(Collectors.toList());
    }
}
