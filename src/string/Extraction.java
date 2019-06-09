package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extraction {

	public static String extractionScreenName(String txet) {
		String screenName = null;
		Pattern pattern = Pattern.compile("[^RT @]+[a-zA-Z0-9_][:$]");
		Matcher matcher = pattern.matcher(txet);
		if (matcher.find()){
		screenName = matcher.group().replaceAll(":", "");
		//System.out.println("screenName=" + screenName);
		}
		return screenName;
	}
}
