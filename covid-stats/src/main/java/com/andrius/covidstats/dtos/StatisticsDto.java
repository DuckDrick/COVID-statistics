package com.andrius.covidstats.dtos;

import com.andrius.covidstats.entities.YearWeek;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Map;

@Getter
@Setter
@Builder
public class StatisticsDto {
    private String country;
    private Map<YearWeek, BigInteger> cases;
    private Map<YearWeek, BigInteger> deaths;
}
