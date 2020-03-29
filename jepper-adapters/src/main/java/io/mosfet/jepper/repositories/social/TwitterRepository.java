package io.mosfet.jepper.repositories.social;

import io.mosfet.jepper.domain.social.SocialRepository;
import io.mosfet.jepper.domain.social.exceptions.SocialException;
import io.mosfet.jepper.domain.social.twitter.Tweet;
import io.mosfet.jepper.domain.social.twitter.TwitterResult;
import io.mosfet.jepper.domain.social.twitter.TwitterThread;
import java.util.List;
import org.springframework.stereotype.Repository;
import twitter4j.*;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
@Repository
public class TwitterRepository implements SocialRepository {

  private final Twitter twitter;

  public TwitterRepository() {
    this.twitter = TwitterFactory.getSingleton();
  }

  public TwitterRepository(Twitter twitter) {
    this.twitter = twitter;
  }

  @Override
  public TwitterResult updateStatus(TwitterThread twitterThread) throws SocialException {
    List<Tweet> tweets = twitterThread.tweets();
    try {
      Status statusUpdate = twitter.updateStatus(new StatusUpdate(tweets.get(0).getText()));
      for (Tweet tweet : tweets.subList(1, tweets.size())) {
        statusUpdate =
            twitter.updateStatus(
                new StatusUpdate(tweet.getText()).inReplyToStatusId(statusUpdate.getId()));
      }
      return new TwitterResult(statusUpdate.getId(), statusUpdate.getText());
    } catch (TwitterException e) {
      throw new SocialException(e);
    }
  }
}
