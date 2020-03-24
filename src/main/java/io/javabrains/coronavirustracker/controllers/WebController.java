package io.javabrains.coronavirustracker.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataServices;

/*
 * adds our controller to get all the data and add it into the website
 * 
 * Brady Haden
 */

// not a rest controller because we want HTML UI output
@Controller
public class WebController
{
  // use this to get access to CoronaVirusDataServices
  @Autowired
  CoronaVirusDataServices coronaVirusDataService;

  // whatever the return value is should be the HTML file that we are going to
  // update into
  // thymeleaf dependency in spring allows for this to work
  /*
   * home shows the confirmed cases and 1-day change in cases
   */
  @RequestMapping("/home")
  public String home(Model model)
  {

    List<LocationStats> confirmedStats = coronaVirusDataService
        .getConfirmedStats();
    // sorts the data
    // see LocationStatsComparator class
    Collections.sort(confirmedStats, new LocationStatsComparator());

    int totalReportedCases = confirmedStats.stream()
        .mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewCases = confirmedStats.stream()
        .mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

    model.addAttribute("locationStats", confirmedStats);
    model.addAttribute("totalReportedCases", totalReportedCases);
    model.addAttribute("totalNewCases", totalNewCases);

    return "home";
  }

  /*
   * death shows the confirmed deaths and 1-day change
   */
  @RequestMapping("/deaths")
  public String deaths(Model model)
  {

    List<LocationStats> deathStats = coronaVirusDataService.getDeathStats();
    // sorts the data
    // see LocationStatsComparator class
    Collections.sort(deathStats, new LocationStatsComparator());

    int totalReportedDeaths = deathStats.stream()
        .mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewDeaths = deathStats.stream()
        .mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

    model.addAttribute("locationStats", deathStats);
    model.addAttribute("totalReportedCases", totalReportedDeaths);
    model.addAttribute("totalNewCases", totalNewDeaths);

    return "deaths";
  }

  /*
   * death shows the confirmed deaths and 1-day change
   */
  @RequestMapping("/recovered")
  public String recovered(Model model)
  {

    List<LocationStats> recoveredStats = coronaVirusDataService
        .getRecoveredStats();
    // sorts the data
    // see LocationStatsComparator class
    Collections.sort(recoveredStats, new LocationStatsComparator());

    int totalReportedRecoveries = recoveredStats.stream()
        .mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewRecoveries = recoveredStats.stream()
        .mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

    model.addAttribute("locationStats", recoveredStats);
    model.addAttribute("totalReportedCases", totalReportedRecoveries);
    model.addAttribute("totalNewCases", totalNewRecoveries);

    return "recovered";
  }

}
