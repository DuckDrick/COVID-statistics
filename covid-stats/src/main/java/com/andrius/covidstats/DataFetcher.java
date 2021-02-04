package com.andrius.covidstats;

import com.andrius.covidstats.entities.Data;
import com.andrius.covidstats.repositories.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFetcher {
    public static void fetchData() {
        try {
            var url = new URL("https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/");
            Repository.data = Arrays.asList(new ObjectMapper().readValue(url, Data[].class));
        } catch (IOException e) {
            e.printStackTrace();
            Repository.data = new ArrayList<>();
        }
    }
}
