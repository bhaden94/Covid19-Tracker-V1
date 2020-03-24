package io.javabrains.coronavirustracker.controllers;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import io.javabrains.coronavirustracker.models.LocationStats;

/*
 * Sorts all of our data by this: total cases, country, state, difference from
 * previous day
 * 
 * Brady Haden
 */

public class LocationStatsComparator implements Comparator<LocationStats>
{

  @Override
  public int compare(LocationStats o1, LocationStats o2)
  {
    return new CompareToBuilder()
        .append(o2.getLatestTotalCases(), o1.getLatestTotalCases())
        .append(o2.getCountry(), o1.getCountry())
        .append(o2.getState(), o1.getState())
        .append(o2.getDiffFromPrevDay(), o1.getDiffFromPrevDay())
        .toComparison();
  }

}
