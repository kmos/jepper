package io.mosfet.jepper.domain.services;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.social.SocialRepository;
import io.mosfet.jepper.domain.social.exceptions.SocialException;
import io.mosfet.jepper.domain.social.twitter.TwitterResult;
import io.mosfet.jepper.domain.social.twitter.TwitterThread;
import org.springframework.stereotype.Service;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
@Service
public class SocialService {

  private SocialRepository socialRepository;

  public SocialService(SocialRepository socialRepository) {
    this.socialRepository = socialRepository;
  }

  public TwitterResult publish(Jep jep) throws SocialException {
    TwitterThread twitterThread = new TwitterThread.Builder().fromJep(jep).build();
    return socialRepository.updateStatus(twitterThread);
  }
}
