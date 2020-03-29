package io.mosfet.jepper.domain.services;

import io.mosfet.jepper.domain.social.exceptions.SocialException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
class BotServiceTest {

  public static final String CONSUMER_KEY = "CONSUMER_KEY";
  public static final String CONSUMER_SECRET = "CONSUMER_SECRET";
  public static final String ACCESS_KEY = "ACCESS_KEY";
  public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

  @Test
  void sendAmessage() throws IOException, SocialException {

    /*    String consumerKey = System.getenv(CONSUMER_KEY);
    String consumerSecret = System.getenv(CONSUMER_SECRET);
    String accessKey = System.getenv(ACCESS_KEY);
    String accessToken = System.getenv(ACCESS_TOKEN);

    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthConsumer(consumerKey, consumerSecret);
    twitter.setOAuthAccessToken(new AccessToken(accessKey, accessToken));

    BotService botService =
        new BotService(
            new JepService(new OpenJDKRepository()),
            new SocialService(new TwitterRepository(twitter)));

    botService.createJep(12);*/
    int min = 11;
    int max = 14;
    System.out.println(ThreadLocalRandom.current().nextInt(min, max));
  }
}
