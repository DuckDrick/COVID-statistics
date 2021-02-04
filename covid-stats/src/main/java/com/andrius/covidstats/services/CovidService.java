package com.andrius.covidstats.services;

import com.andrius.covidstats.entities.Data;
import com.andrius.covidstats.repositories.Repository;
import com.andrius.covidstats.dtos.StatisticsDto;
import com.andrius.covidstats.entities.YearWeek;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CovidService {

    public StatisticsDto getStatisticsOfCountry(String country) {
        var data = Repository.getDataOfCountry(country);
        return StatisticsDto.builder().country(country)
                .cases(datesAndCounts("cases", data))
                .deaths(datesAndCounts("deaths", data)).build();
    }

    private Map<YearWeek, BigInteger> datesAndCounts (String indicator, List<Data> data) {
        var map = data.stream().filter(d -> d.getIndicator().equals(indicator))
                .collect(Collectors.toMap(Data::getYearWeek, Data::getWeeklyCount));
        return new TreeMap<>(map);
    }

    public Map<String, String> getCountriesAndCodes() {
        return Repository.data.stream()
                .collect(TreeMap::new,
                        (treeMap, value) -> treeMap.put(value.getCountry(), value.getCountryCode()),
                        TreeMap::putAll);
    }
}
