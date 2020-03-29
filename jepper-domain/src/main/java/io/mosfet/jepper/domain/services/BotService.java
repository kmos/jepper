package io.mosfet.jepper.domain.services;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.social.exceptions.SocialException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
@Service
public class BotService {

  public static final int FROM = 11;
  public static final int TO = 14;
  private final JepService jepService;
  private final SocialService socialService;

  public BotService(JepService jepService, SocialService socialService) {
    this.jepService = jepService;
    this.socialService = socialService;
  }

  // @Scheduled(cron = "5 * * * * *")
  void findRandomJepAndPublishToTwitter()
      throws IOException, SocialException, NoSuchAlgorithmException {
    int jdk = ThreadLocalRandom.current().nextInt(FROM, TO);
    List<Jep> jeps = jepService.getJeps(jdk);

    UrlValidator urlValidator = new UrlValidator();
    SecureRandom random = SecureRandom.getInstanceStrong();
    int randomIndex = random.nextInt(jeps.size());
    while (!urlValidator.isValid(jeps.get(randomIndex).getRawJep().getLink())) {
      randomIndex = random.nextInt(jeps.size());
    }

    socialService.publish(jeps.get(randomIndex));
  }
}
