package io.mosfet.jepper.domain.social.twitter;

import io.mosfet.jepper.domain.jdk.Jep;
import java.util.ArrayList;
import java.util.List;

/** Created with love. User: mosfet Date: 05/03/20 github: kmos twitter: nmosf */
public class TwitterThread {

  private List<Tweet> tweets;

  private TwitterThread(Builder builder) {
    tweets = builder.tweets;
  }

  public List<Tweet> tweets() {
    return this.tweets;
  }

  public Tweet introduction() {
    return this.tweets.get(0);
  }

  public static final class Builder {
    private List<Tweet> tweets;

    public Builder() {
      tweets = new ArrayList<>();
    }

    public Builder fromJep(Jep jep) {
      String firstTweet = jep.getRawJep().toString();
      this.tweets.add(0, new Tweet(firstTweet));

      List<String> words = jep.splitSummary();
      tweetsBuilder(words);

      return this;
    }

    private void tweetsBuilder(List<String> words) {
      StringBuilder stringBuilder = new StringBuilder();
      for (String word : words) {
        splitInTweets(word, stringBuilder);
      }
      if (stringBuilder.length() != 0) {
        tweets.add(new Tweet(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString()));
      }
    }

    private void splitInTweets(String word, StringBuilder stringBuilder) {
      if (stringBuilder.length() >= Tweet.MAX_LENGTH) {
        tweets.add(new Tweet(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString()));
        stringBuilder.setLength(0);
        stringBuilder.trimToSize();
      }
      stringBuilder.append(word).append(" ");
    }

    public TwitterThread build() {
      return new TwitterThread(this);
    }
  }
}
