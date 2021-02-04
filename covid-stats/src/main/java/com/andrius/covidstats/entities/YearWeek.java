package com.andrius.covidstats.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class YearWeek implements Comparable<YearWeek>{
    private Integer year;
    private Integer week;

    @Override
    public String toString(){
        return this.year + "-" + this.week;
    }

    @Override
    public int compareTo(YearWeek o) {
        var yearCompare = this.year.compareTo(o.year);
        return yearCompare == 0 ? this.week.compareTo(o.week) : yearCompare;
    }
}
