package io.mosfet.jepper.domain.services;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import io.mosfet.jepper.domain.jdk.JDKRepository;
import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.jdk.RawJep;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/** Created with love. User: mosfet Date: 01/03/20 github: kmos twitter: nmosf */
class JepServiceTest {

  public static final String MOCKED_SUMMARY = "the best summary in the world!";
  public static final String MOCKED_ID = "0";
  public static final String MOCKED_HOST = "localhost";
  public static final String MOCKED_DESCRIPTION = "the best jep";
  public static final RawJep BEST_RAW_RAW_JEP =
      new RawJep(MOCKED_ID, MOCKED_HOST, MOCKED_DESCRIPTION);

  @Mock JDKRepository jdkRepository;

  JepService jepService;

  @BeforeEach
  void setUp() {
    initMocks(this);
    jepService = new JepService(jdkRepository);
  }

  @Test
  @DisplayName("given the java version, return the list of JEPS")
  void givenTheJavaVersionReturnTheListOfJeps() throws IOException {

    when(jdkRepository.getJdkEnhancementProposals(12))
        .thenReturn(Collections.singletonList(BEST_RAW_RAW_JEP));

    when(jdkRepository.getJepSummary(MOCKED_HOST)).thenReturn(MOCKED_SUMMARY);

    List<Jep> jeps = jepService.getJeps(12);

    Assertions.assertEquals(MOCKED_SUMMARY, jeps.get(0).getSummary());
    Assertions.assertEquals(BEST_RAW_RAW_JEP, jeps.get(0).getRawJep());
  }
}
