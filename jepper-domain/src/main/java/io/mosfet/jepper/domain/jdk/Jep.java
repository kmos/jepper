package io.mosfet.jepper.domain.jdk;

import java.util.Arrays;
import java.util.List;

/** Created with love. User: mosfet Date: 01/03/20 github: kmos twitter: nmosf */
public class Jep {

  private RawJep rawJep;
  private String summary;

  public Jep(RawJep rawJep, String summary) {
    this.rawJep = rawJep;
    this.summary = summary;
  }

  public RawJep getRawJep() {
    return rawJep;
  }

  public String getSummary() {
    return summary;
  }

  public List<String> splitSummary() {
    return Arrays.asList(summary.split(" "));
  }
}
