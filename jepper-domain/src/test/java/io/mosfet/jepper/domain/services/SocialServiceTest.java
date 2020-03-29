package io.mosfet.jepper.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.jdk.RawJep;
import io.mosfet.jepper.domain.social.SocialRepository;
import io.mosfet.jepper.domain.social.exceptions.SocialException;
import io.mosfet.jepper.domain.social.twitter.TwitterResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/** Created with love. User: mosfet Date: 02/03/20 github: kmos twitter: nmosf */
class SocialServiceTest {

  public static final Jep JEP =
      new Jep(new RawJep("0", "https://localhost/jep", "a fabulous jep"), "a fabulous super jep");
  public static final TwitterResult STATUS_MESSAGE = new TwitterResult(0, "wow");

  @Mock SocialRepository socialRepository;

  private SocialService socialService;

  @BeforeEach
  void setUp() {
    initMocks(this);
    socialService = new SocialService(socialRepository);
  }

  @Test
  @DisplayName("given a Jep, return a TwitterResult")
  void givenJepReturnTwitterResult() throws SocialException {

    when(socialRepository.updateStatus(any())).thenReturn(STATUS_MESSAGE);
    TwitterResult update = socialService.publish(JEP);
    assertEquals(STATUS_MESSAGE, update);
  }
}
