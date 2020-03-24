package io.javabrains.coronavirustracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * This is the main method to run our application
 * 
 * Brady Haden
 */

@SpringBootApplication
// used for scheduling in fetchVirusData() method
@EnableScheduling
public class CoronavirusTrackerApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(CoronavirusTrackerApplication.class, args);
  }

}
