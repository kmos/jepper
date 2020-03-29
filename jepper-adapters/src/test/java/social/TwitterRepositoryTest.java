package social;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import io.mosfet.jepper.domain.jdk.Jep;
import io.mosfet.jepper.domain.jdk.RawJep;
import io.mosfet.jepper.domain.social.exceptions.SocialException;
import io.mosfet.jepper.domain.social.twitter.TwitterThread;
import io.mosfet.jepper.repositories.social.TwitterRepository;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import twitter4j.*;

/** Created with love. User: mosfet Date: 15/03/20 github: kmos twitter: nmosf */
class TwitterRepositoryTest {

  public static final String DESCRIPTION =
      "Extend the switch statement so that it can be used as either a statement or an expression, and that both forms can use either a \"traditional\" or \"simplified\" scoping and control flow behavior. These changes will simplify everyday coding, and also prepare the way for the use of pattern matching (JEP 305) in switch. This is a preview language feature in JDK 12.Please note: this JEP is superseded by JEP 354, which targets JDK 13.";
  public static final String LITTLE_SUMMARY = "wow";
  public static final String ADDRESS = "http://localhost";
  public static final String ID = "0";

  @Mock Twitter twitter;

  private TwitterRepository twitterRepository;

  @BeforeEach
  void setUp() {
    initMocks(this);
    twitterRepository = new TwitterRepository(twitter);
  }

  @Test
  @DisplayName("given a thread composed by three tweets then publish three tweets")
  void givenAThreadWithThreeTweetsThenPublishThreeTweets()
      throws SocialException, TwitterException {
    TwitterThread twitterThread =
        new TwitterThread.Builder()
            .fromJep(new Jep(new RawJep(ID, ADDRESS, LITTLE_SUMMARY), DESCRIPTION))
            .build();
    when(twitter.updateStatus(any(StatusUpdate.class))).thenReturn(getMockedStatus());
    twitterRepository.updateStatus(twitterThread);
    verify(twitter, times(3)).updateStatus(any(StatusUpdate.class));
  }

  private Status getMockedStatus() {
    return new Status() {
      @Override
      public Date getCreatedAt() {
        return null;
      }

      @Override
      public long getId() {
        return 0;
      }

      @Override
      public String getText() {
        return "a mocked status update";
      }

      @Override
      public int getDisplayTextRangeStart() {
        return 0;
      }

      @Override
      public int getDisplayTextRangeEnd() {
        return 0;
      }

      @Override
      public String getSource() {
        return null;
      }

      @Override
      public boolean isTruncated() {
        return false;
      }

      @Override
      public long getInReplyToStatusId() {
        return 0;
      }

      @Override
      public long getInReplyToUserId() {
        return 0;
      }

      @Override
      public String getInReplyToScreenName() {
        return null;
      }

      @Override
      public GeoLocation getGeoLocation() {
        return null;
      }

      @Override
      public Place getPlace() {
        return null;
      }

      @Override
      public boolean isFavorited() {
        return false;
      }

      @Override
      public boolean isRetweeted() {
        return false;
      }

      @Override
      public int getFavoriteCount() {
        return 0;
      }

      @Override
      public User getUser() {
        return null;
      }

      @Override
      public boolean isRetweet() {
        return false;
      }

      @Override
      public Status getRetweetedStatus() {
        return null;
      }

      @Override
      public long[] getContributors() {
        return new long[0];
      }

      @Override
      public int getRetweetCount() {
        return 0;
      }

      @Override
      public boolean isRetweetedByMe() {
        return false;
      }

      @Override
      public long getCurrentUserRetweetId() {
        return 0;
      }

      @Override
      public boolean isPossiblySensitive() {
        return false;
      }

      @Override
      public String getLang() {
        return null;
      }

      @Override
      public Scopes getScopes() {
        return null;
      }

      @Override
      public String[] getWithheldInCountries() {
        return new String[0];
      }

      @Override
      public long getQuotedStatusId() {
        return 0;
      }

      @Override
      public Status getQuotedStatus() {
        return null;
      }

      @Override
      public URLEntity getQuotedStatusPermalink() {
        return null;
      }

      @Override
      public int compareTo(Status o) {
        return 0;
      }

      @Override
      public UserMentionEntity[] getUserMentionEntities() {
        return new UserMentionEntity[0];
      }

      @Override
      public URLEntity[] getURLEntities() {
        return new URLEntity[0];
      }

      @Override
      public HashtagEntity[] getHashtagEntities() {
        return new HashtagEntity[0];
      }

      @Override
      public MediaEntity[] getMediaEntities() {
        return new MediaEntity[0];
      }

      @Override
      public SymbolEntity[] getSymbolEntities() {
        return new SymbolEntity[0];
      }

      @Override
      public RateLimitStatus getRateLimitStatus() {
        return null;
      }

      @Override
      public int getAccessLevel() {
        return 0;
      }
    };
  }
}
