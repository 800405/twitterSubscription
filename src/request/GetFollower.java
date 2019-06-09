package request;

import java.util.ArrayList;

import login.Login;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * @author eiryu
 *
 */
public class GetFollower {

	private static final int ID_COUNT_PER_REQUEST = 5000;

	public static ArrayList<String> getFriends(String targetScreenName) throws TwitterException, InterruptedException {
		Twitter twitter = Login.twitterLogin();

		// カーソル初期値
		long cursor = -1L;
		// 一時的にIDを格納するオブジェクト
		IDs ids;
		// IDを全てストックするオブジェクト
		ArrayList<String> followerIDs = new ArrayList<>();

		long page = 1L;
		int t = 0;
		do {
			t++;
			if (t % 16 == 0) {
				try {
					// Thread.sleep(60*1000);
					System.out.println("後15分まち");
					Thread.sleep(5 * 60 * 1000);
					System.out.println("後10分まち");
					Thread.sleep(5 * 60 * 1000);
					System.out.println("後5分まち");
					Thread.sleep(5 * 60 * 1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// 状況表示
			System.out.println(String.format("%dページ目取得中。。(%d <= %d)", page, ID_COUNT_PER_REQUEST * (page - 1),
					ID_COUNT_PER_REQUEST * page++));
			ids = // twitter.getFollowersIDs(targetScreenName, cursor);
					// 新しい順に取得
					twitter.getFriendsIDs(targetScreenName, cursor);

			// 取得したIDを格納
			int c = 0;
			for (long id : ids.getIDs()) {
				System.out.print(c+++":");
				String ScreenName=twitter.lookupUsers(id).get(0).getScreenName();
				System.out.println(id + ",@" + ScreenName);
				followerIDs.add(ScreenName);
			}

			// 次のページへのカーソル取得
			cursor = ids.getNextCursor();
		} while (ids.hasNext());

		return followerIDs;

	}
}