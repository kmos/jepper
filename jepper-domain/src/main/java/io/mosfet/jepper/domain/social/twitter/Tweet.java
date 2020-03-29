package io.mosfet.jepper.domain.social.twitter;

/** Created with love. User: mosfet Date: 05/03/20 github: kmos twitter: nmosf */
public class Tweet {

  public static final int MAX_LENGTH = 230;
  private final String text;

  public Tweet(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
