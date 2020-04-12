package io.javabrains.coronavirustracker.models;

import java.sql.Date;

public class GraphStats
{
  private Date date;
  private int casesThisDay;
  private int deathsThisDay;
  private int recoveredThisDay;

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public int getRecoveredThisDay()
  {
    return recoveredThisDay;
  }

  public void setRecoveredThisDay(int recoveredThisDay)
  {
    this.recoveredThisDay = recoveredThisDay;
  }

  public int getDeathsThisDay()
  {
    return deathsThisDay;
  }

  public void setDeathsThisDay(int deathsThisDay)
  {
    this.deathsThisDay = deathsThisDay;
  }

  public int getCasesThisDay()
  {
    return casesThisDay;
  }

  public void setCasesThisDay(int casesThisDay)
  {
    this.casesThisDay = casesThisDay;
  }

  @Override
  public String toString()
  {
    return "GraphStats [date=" + date + ", casesThisDay=" + casesThisDay
        + ", deathsThisDay=" + deathsThisDay + "]";
  }

}
