package io.mosfet.jepper.domain.social.twitter;

import static org.junit.jupiter.api.Assertions.*;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.jdk.RawJep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
class TwitterThreadTest {

  public static final String DESCRIPTION = "I am a beautiful jep";
  public static final String LITTLE_SUMMARY = "wow";
  public static final String ADDRESS = "http://localhost";
  public static final String ID = "0";
  public static final String BIG_DESCRIPTION_PART_1 =
      "Extend the switch statement so that it can be used as either a statement or an expression, and that both forms can use either a \"traditional\" or \"simplified\" scoping and control flow behavior. These changes will simplify everyday";
  public static final String BIG_DESCRIPTION_PART_2 =
      "coding, and also prepare the way for the use of pattern matching (JEP 305) in switch. This is a preview language feature in JDK 12.Please note: this JEP is superseded by JEP 354, which targets JDK 13.";

  @Test
  @DisplayName(
      "given a jep with a description of less than 230 characters, when build a TwitterThread, return a TwitterThread of 2 tweets")
  void givenLittleJepReturnTwoTweets() {
    RawJep LITTLE_Raw_JEP = new RawJep(ID, ADDRESS, DESCRIPTION);
    Jep jep = new Jep(LITTLE_Raw_JEP, LITTLE_SUMMARY);
    TwitterThread twitterThread = new TwitterThread.Builder().fromJep(jep).build();

    assertEquals(LITTLE_Raw_JEP.toString(), twitterThread.introduction().getText());
    assertEquals(LITTLE_SUMMARY, twitterThread.tweets().get(1).getText());
  }

  @Test
  @DisplayName(
      "given a jep with a description of more than 230 characters, when build a TwitterThread, return a TwitterThread of 4 tweets")
  void givenBigJepReturnFourTweets() {
    RawJep BIG_Raw_JEP = new RawJep(ID, ADDRESS, DESCRIPTION);
    Jep jep = new Jep(BIG_Raw_JEP, BIG_DESCRIPTION_PART_1 + " " + BIG_DESCRIPTION_PART_2);
    TwitterThread twitterThread = new TwitterThread.Builder().fromJep(jep).build();

    assertEquals(BIG_Raw_JEP.toString(), twitterThread.introduction().getText());
    assertEquals(BIG_DESCRIPTION_PART_1.length(), twitterThread.tweets().get(1).getText().length());
    assertEquals(BIG_DESCRIPTION_PART_1, twitterThread.tweets().get(1).getText());
    assertEquals(BIG_DESCRIPTION_PART_2, twitterThread.tweets().get(2).getText());
  }
}
