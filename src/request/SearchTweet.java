package request;

import java.util.ArrayList;

import login.Login;
import setting.TweetSteatus;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class SearchTweet {

	// filter:verified承認アカウント
	// リプライを除く -filter:replies

	public static ArrayList<TweetSteatus> search(String _searchWord, int _countMax100, String _since, String _until) {
		Twitter twitter = Login.twitterLogin();
		Query query = new Query();
		QueryResult result = null;

		ArrayList<TweetSteatus> tweets = new ArrayList<>();

		// 検索ワードをセット
		query.setQuery(_searchWord);
		// 1度のリクエストで取得するTweetの数（100が最大）
		query.setCount(_countMax100);
		// 期間指定 例"2019-05-12_00:00:00_JST"
		query.setSince(_since + "_JST");
		query.setUntil(_until + "_JST");
		System.out.println(query.toString());

		int c = 0;
		try {

			// 1500件（15ページ）15分間にごとの最大数
			for (int i = 1; i <= 15; i++) {
				// 検索実行
				result = twitter.search(query);

				System.out.println("ヒット数 : " + result.getTweets().size());
				System.out.println("ページ数 : " + i);

				c = c + result.getTweets().size();
				// 検索結果を見てみる
				for (Status s : result.getTweets()) {
					String screenName = s.getUser().getScreenName();
					long id = s.getUser().getId();
					long tweetId = s.getId();
					String tweetText = s.getText();

					TweetSteatus tweet = new TweetSteatus(screenName, id, tweetId, tweetText);
					System.out.println("@" + screenName);
					System.out.println(tweetText);
					tweets.add(tweet);
				}

				if (result.hasNext()) {
					query = result.nextQuery();
				} else {
					break;
				}
			}

		} catch (TwitterException e) {
			e.printStackTrace();
		}
		System.out.println("総ヒット数 : " + c);
		return tweets;
	}

}
