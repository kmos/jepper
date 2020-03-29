package io.mosfet.jepper.domain.services;

import io.mosfet.jepper.domain.jdk.JDKRepository;
import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.jdk.RawJep;
import org.jooq.lambda.Unchecked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/** Created with love. User: mosfet Date: 01/03/20 github: kmos twitter: nmosf */
@Service
public class JepService {

  private final JDKRepository jdkRepository;
  private final Logger log = LoggerFactory.getLogger(JepService.class);

  public JepService(JDKRepository jdkRepository) {
    this.jdkRepository = jdkRepository;
  }

  public List<Jep> getJeps(int jdk) throws IOException {
    log.debug("jdk:{}", jdk);
    return jdkRepository.getJdkEnhancementProposals(jdk).stream()
        .map(Unchecked.function(this::enrichRawJepWithSummary))
        .collect(Collectors.toList());
  }

  private Jep enrichRawJepWithSummary(RawJep rawJep) throws IOException {
    log.debug("enrich jep with summary taken from: {}", rawJep.getLink());
    log.debug("jep: {}", rawJep.getShortDescription());
    return new Jep(rawJep, jdkRepository.getJepSummary(rawJep.getLink()));
  }
}
