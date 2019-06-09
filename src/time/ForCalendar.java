package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ForCalendar extends TimeConfigurator {

	public static String getNowTimeForCalender() {
		return getNowTimeForCalender(getDateFormat());
	}

	public static String getNowTimeForCalender(String format) {
		Calendar calendar = Calendar.getInstance();

		// SimpleDateFormatクラスでフォーマットパターンを設定する
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String nowTime = sdf.format(calendar.getTime());
		return nowTime;
	}

	
}
