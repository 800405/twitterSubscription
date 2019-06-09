package setting;

public class TweetSteatus {

	private String screenName = "";
	private long id = 0L;
	private long tweetId = 0L;
	private String tweetText = "";

	public TweetSteatus(String _screenName, long _id, long _tweetId, String _tweetText) {
		this.screenName = _screenName;
		this.id = _id;
		this.tweetId = _tweetId;
		this.tweetText = _tweetText;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String toString() {
		String br = System.getProperty("line.separator");
		return "["+getScreenName()+",ID="+getId()+",TweetID="+getTweetId()+"]"+br+getTweetText();
	}

}
