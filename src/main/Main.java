package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import login.Login;
import request.SearchTweet;
import setting.TweetSteatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Main {

	public static void main(String[] args) throws TwitterException, IllegalStateException, InterruptedException {

		Twitter twitter = Login.twitterLogin();

		// ツイート検索ワード
		String searchWord = "リツート プレゼント";
		int searchCount = 100;

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(time.CalculateTime.getDateFormat());
		// 期間検索 １時間前
		calendar.add(Calendar.DATE, -1);
		String since = sdf.format(calendar.getTime());
		// 検索期間 現在
		String until = time.ForCalendar.getNowTimeForCalender().toString();

		// フォローするスクリーンネーム
		String screenName = null;
		//一度の処理での最大フォロー数
		int Maxfollow = 15;

		// ①フォロー数の取得・1901以上なら減らす

		ArrayList<String> friendsName = request.GetFollower.getFriends(twitter.getScreenName());

		if (friendsName.size() > 1900) {
			for (int i = friendsName.size(); i < 1900; i--) {
				String name = friendsName.get(i);
				request.Follow.anfollow(name);
			}
		}

		// ②ツイート検索
		System.out.println(searchWord + "," + searchCount + ", " + since + "," + until);
		ArrayList<TweetSteatus> tweet = SearchTweet.search(searchWord, searchCount, since, until);

		System.out.println(tweet.size());

		int c = 0;
		for (TweetSteatus t : tweet) {
			try {
				//③取得したツイートをリツイート
				twitter.retweetStatus(t.getTweetId());
			} catch (TwitterException e) {
				//リツートしているかを取得できない
				//System.out.println("リツイートで失敗");
				continue;
			}

			try {
				// ④-1リツイート元アカウントをフォロー
				if (t.getTweetText().contains("RT @")) {
					screenName = string.Extraction.extractionScreenName(t.getTweetText());

				} else {
					// ④-2リツートでなければツイートアカウントをフォロー
					screenName = t.getScreenName();
				}
				String sN = new String(screenName);
				if (friendsName.contains(sN) | screenName.equals(null) | screenName.equals("")) {
					continue;
				}
				System.out.println("screenName=" + screenName + " :" + t.getTweetText());

				friendsName.add(sN);
				if (request.Follow.follow(sN)) {
					c++;

					if (c > Maxfollow) {
						break;
					}
				}

			} catch (TwitterException e) {
				System.out.println("フォローで失敗");
				//処理を止めたくないので再処理
				continue;
			}
		}

	}
}
