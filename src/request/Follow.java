package request;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Follow {

	static Twitter twitter = login.Login.twitterLogin();

	public static Boolean follow(long _id) throws TwitterException {
		// 二人の関係からすでにこちらが相手をフォロー済みなら
		if (twitter.showFriendship(twitter.getId(), _id).isSourceFollowingTarget()) {
			System.out.println("すでにフォロー済みだった");
			return false;
		}
		twitter.createFriendship(_id);
		return true;
	}

	public static Boolean follow(String _screenName) throws TwitterException {
		// 二人の関係からすでにこちらが相手をフォロー済みなら
		if (twitter.showFriendship(twitter.getScreenName(), _screenName).isSourceFollowingTarget()) {
			System.out.println("すでにフォロー済みだった");
			return false;
		}
		twitter.createFriendship(_screenName);
		return true;
	}

	public static Boolean anfollow(long _id) throws TwitterException {
		if (!twitter.showFriendship(twitter.getId(), _id).isSourceFollowingTarget()) {
			System.out.println("フォローしていなかった");
			return false;
		}
		twitter.destroyFriendship(_id);
		return true;
	}

	public static Boolean anfollow(String _screenName) throws TwitterException {
		if (!twitter.showFriendship(twitter.getScreenName(), _screenName).isSourceFollowingTarget()) {
			System.out.println("フォローしていなかった");
			return false;
		}
		twitter.destroyFriendship(_screenName);
		return true;
	}
}
