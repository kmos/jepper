package io.mosfet.jepper.domain.services;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.repositories.jdk.OpenJDKRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created with love.
 * User: mosfet
 * Date: 28/03/20
 * github: kmos
 * twitter: nmosf
 */
public class JepServiceIntegrationTest {

  private JepService jepService;

  @Test
  void getAllJepFromJdk12() throws IOException {
    jepService = new JepService(new OpenJDKRepository());
    List<Jep> jeps = jepService.getJeps(12);
    Assertions.assertEquals(8, jeps.size());
  }
}
