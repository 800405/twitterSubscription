package request;

import java.util.Random;

import login.Login;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Tweet {

	 public static void main(String[] args) {
		 Random random = new Random();
		 int ran = random.nextInt(13);
		 String[] tweets = {
				 "他人に対しても自分に対しても親切であること。\n" +
				 "人の生きるのを助け、自分自身の生きるのを助けること。\n" +
				 "これこそが真の思いやりである。",

				 "ただ自分自身であることに満足し、比較したり競争することがないのであれば、すべての人が君を尊敬するだろう。\"",
				 "全ての人には個性の美しさがある。",
				 "しなっ",
				 "いかに生きるかを学ぶには全生涯を要す。",
				 "精神には休養を与えねばならぬ。絶えず緊張を加えれば、精神の飛翔を妨げることになる。",
				 "私は、敵を倒した者より、自分の欲望を克服した者の方を、より勇者と見る。\n" +
				 "自らに勝つ事こそ、最も難しい勝利だからだ。",
				 "すべては疑いうる。",
				 "この世で成功するのは、馬鹿のように見せかけ、利口に行動することである。",
				 "純粋な喜びのひとつは勤労後の休息である。",
				 "人の悪徳、欠点は牡蠣の中の砂粒のようなものだ。\n" +
				 "私たちは、これを真珠にしなければならない。",
				 "ともに泣くことの楽しさほど、人々を結びつけるものはない。"
		 };
		 tweet(tweets[ran]);


	}
	public static void tweet(String _tweetText) {
			try{
				Twitter twitter =Login.twitterLogin();
				twitter.updateStatus(_tweetText);
			//Thread.sleep(1*30*1000);
			System.out.println("ツイートしたよ");
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
		}
		}
}
