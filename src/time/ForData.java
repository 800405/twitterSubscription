package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForData {

	public static Date getNowTimeForData() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(date.getTime()));
		return date;
	}

}
