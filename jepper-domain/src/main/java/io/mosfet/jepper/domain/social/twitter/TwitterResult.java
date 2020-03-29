package io.mosfet.jepper.domain.social.twitter;

import java.util.Objects;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
public class TwitterResult {

  private final long id;
  private final String text;

  public TwitterResult(long id, String text) {
    this.id = id;
    this.text = text;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TwitterResult that = (TwitterResult) o;
    return id == that.id && Objects.equals(text, that.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text);
  }
}
