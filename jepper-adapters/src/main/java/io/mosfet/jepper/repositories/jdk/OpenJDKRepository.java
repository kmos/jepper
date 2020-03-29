package io.mosfet.jepper.repositories.jdk;

import io.mosfet.jepper.domain.jdk.JDKRepository;
import io.mosfet.jepper.domain.jdk.RawJep;
import io.mosfet.jepper.repositories.jdk.markup.Html;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.lambda.Unchecked;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Repository;

/** Created with love. User: mosfet Date: 01/03/20 github: kmos twitter: nmosf */
@Repository
public class OpenJDKRepository implements JDKRepository {

  public static final String OPEN_JDK_LINK = "https://openjdk.java.net/projects/jdk/";
  public static final String OPENJDK_JEPS_LINK = "//openjdk.java.net/jeps/";
  public static final String HTTPS = "https:";

  @Override
  public List<RawJep> getJdkEnhancementProposals(int jdk) throws IOException {
    String url = OPEN_JDK_LINK + jdk;
    return Jsoup.connect(url).get().select(Html.BLOCKQUOTE).first().select(Html.A).stream()
        .map(Unchecked.function(this::fromElement))
        .collect(Collectors.toList());
  }

  @Override
  public String getJepSummary(String link) throws IOException {
    return Jsoup.connect(link).get().select(Html.P).first().text();
  }

  private RawJep fromElement(Element element) {
    return new RawJep(getJepId(element), formatLink(element), element.text());
  }

  private String formatLink(Element element) {
    return HTTPS + element.attr(Html.HREF);
  }

  private String getJepId(Element element) {
    return element.attr(Html.HREF).replace(OPENJDK_JEPS_LINK, "");
  }
}
