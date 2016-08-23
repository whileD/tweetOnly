package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Controller {
    //settings
    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";
    private static final String ACCESS_TOKEN = "";
    private static final String ACCESS_TOKEN_SECRET = "";
    Configuration configuration = new ConfigurationBuilder().setOAuthConsumerKey(CONSUMER_KEY)
            .setOAuthConsumerSecret(CONSUMER_SECRET)
            .setOAuthAccessToken(ACCESS_TOKEN)
            .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET)
            .build();
    Twitter twitter = new TwitterFactory(configuration).getInstance();

    @FXML private TextArea tweetArea;

    @FXML
    public void updateStatus(KeyEvent tweetKey) throws TwitterException{
        if (tweetKey.isControlDown() && tweetKey.getCode().getName().equals("Enter")) {
            String tweet = tweetArea.getText();
            twitter.updateStatus(tweet);
            tweetArea.setText("");
        }
    }
}
