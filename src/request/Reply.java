package request;

import login.Login;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class Reply  {
	public static void main(String[] args) {
		reply();
	}

	public static void reply() {
		Twitter twitter = Login.twitterLogin();
		ResponseList<Status> rep = null;

		// 自分宛のリプを取得
		try {
			rep = twitter.getMentionsTimeline();
			System.out.println(rep);
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		// なにかしらTLが取得できたら
		if (!rep.isEmpty()) {
			for (Status status : rep) {
				User user = status.getUser();
				String toRep = "@" + user.getScreenName() + " " + "成功です";
				String tweet = status.getText();
				try {
					twitter.updateStatus(toRep);
				} catch (TwitterException e) {
					System.out.println("失敗した");
					e.printStackTrace();
				}
			}

		}
	}
}
