package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateTime extends TimeConfigurator {

	// 引数にした日付
	private static String setDateFromStrig;
	private static String setDateToString;
	// Date型への変換
	private static Date dateTo = convertData(setDateToString);;
	private static Date dateFrom = convertData(setDateFromStrig);
	// Date型からlong型への変換
	private static long dateTimeTo = dateTo.getTime();
	private static long dateTimeFrom = dateFrom.getTime();
	// 差を出す項目を設定するためのフォーマット
	private static String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

	public static int monthDiff(String dateFromStrig, String dateToString) throws ParseException {
		setDateFromStrig = dateFromStrig;
		setDateToString = dateToString;
		dateFormat = "yyyy-MM-dd  HH:mm:ss";

		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.DATE, 1);

		Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.DATE, 1);

		int count = 0;
		while (calFrom.before(calTo)) {
			calFrom.add(Calendar.MONTH, 1);
			count++;
		}
		return count;
	}

	public static int daysDiff(String dateFromStrig, String dateToString) {
		setDateFromStrig = dateFromStrig;
		setDateToString = dateToString;
		dateFormat = "yyyy-MM-dd";
		long Diff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);
		return (int) Diff;
	}

	public static int hourDiff(String dateFromStrig, String dateToString) {
		setDateFromStrig = dateFromStrig;
		setDateToString = dateToString;
		dateFormat = "yyyy-MM-dd HH:mm:ss";
		long Diff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60);
		return (int) Diff;
	}

	public static int minutesDiff(String dateFromStrig, String dateToString) {
		setDateFromStrig = dateFromStrig;
		setDateToString = dateToString;
		dateFormat = "yyyy-MM-dd HH:mm:ss";
		long Diff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);
		return (int) Diff;
	}

	public static Date convertData(String dateStrig) {
		Date data = null;
		// Date型に変換
		try {
			data = sdf.parse(dateStrig);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
}
