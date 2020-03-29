package io.mosfet.jepper.domain.jdk;

/** Created with love. User: mosfet Date: 01/03/20 github: kmos twitter: nmosf */
public class RawJep {

  private final String id;
  private final String link;
  private final String shortDescription;

  public RawJep(String id, String link, String shortDescription) {
    this.id = id;
    this.link = link;
    this.shortDescription = shortDescription;
  }

  public String getId() {
    return id;
  }

  public String getLink() {
    return link;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  @Override
  public String toString() {
    return "JEP " + id + ": " + shortDescription + " " + link;
  }
}
