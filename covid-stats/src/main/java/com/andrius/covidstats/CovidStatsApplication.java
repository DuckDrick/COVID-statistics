package com.andrius.covidstats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidStatsApplication {

	public static void main(String[] args) {
		DataFetcher.fetchData();
		SpringApplication.run(CovidStatsApplication.class, args);
	}

}
