package io.mosfet.jepper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created with love.
 * User: mosfet
 * Date: 15/03/20
 * github: kmos
 * twitter: nmosf
 */
@Configuration
public class TwitterConfig {
  TwitterAccount twitterAccount;

  public TwitterConfig(TwitterAccount twitterAccount) {
    this.twitterAccount = twitterAccount;
  }

  @Primary
  @Bean
  public void twitterInit() {
    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthConsumer(twitterAccount.getConsumerKey(), twitterAccount.getConsumerSecret());
    twitter.setOAuthAccessToken(new AccessToken(twitterAccount.getAccessKey(), twitterAccount.getAccessToken()));
  }
}
