package com.andrius.covidstats.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Data{
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    private String continent;
    private BigInteger population;
    private String indicator;
    @JsonProperty("weekly_count")
    private BigInteger weeklyCount;
    @JsonProperty("year_week")
    private YearWeek yearWeek;
    @JsonProperty("rate_14_day")
    private String rate14Day;
    @JsonProperty("cumulative_count")
    private BigInteger cumulativeCount;
    private String source;

    public void setYearWeek(String date) {
        var yearWeek = date.split("-");
        this.yearWeek = new YearWeek(Integer.parseInt(yearWeek[0]), Integer.parseInt(yearWeek[1]));
    }
}
