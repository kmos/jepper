package io.mosfet.jepper.domain.social.exceptions;

import twitter4j.TwitterException;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
public class SocialException extends Exception {

  public SocialException(String message) {
    super(message);
  }

  public SocialException(TwitterException e) {
    super(e);
  }
}
