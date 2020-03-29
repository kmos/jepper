package io.mosfet.jepper.domain.social;

import io.mosfet.jepper.domain.social.exceptions.SocialException;
import io.mosfet.jepper.domain.social.twitter.TwitterResult;
import io.mosfet.jepper.domain.social.twitter.TwitterThread;
import org.springframework.stereotype.Repository;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
@Repository
public interface SocialRepository {
  TwitterResult updateStatus(TwitterThread twitterThread) throws SocialException;
}
