package login;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Login extends Token{

	public static Twitter twitterLogin() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(getConsumerkey(), getConsumersecret());
		twitter.setOAuthAccessToken(new AccessToken(getAccesstoken(), getAccesstokensecret()));
		return twitter;
	}

}
