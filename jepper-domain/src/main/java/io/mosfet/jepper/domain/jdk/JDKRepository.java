package io.mosfet.jepper.domain.jdk;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Repository;

/** Created with love. User: mosfet Date: 15/03/20 github: kmos twitter: nmosf */
@Repository
public interface JDKRepository {
  List<RawJep> getJdkEnhancementProposals(int jdk) throws IOException;

  String getJepSummary(String link) throws IOException;
}
