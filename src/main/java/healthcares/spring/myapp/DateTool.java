package healthcares.spring.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
	public static int dateDiff(String startDate,String endDate)
	{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		
    	try {
			Date startdate = df.parse(startDate);
			Date enddate = df.parse(endDate);
			
			long diff = enddate.getTime() - startdate.getTime();
			
			int dayDiff = (int) (diff / (24 * 60 * 60 * 1000));
			
			return dayDiff;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}

/*Calendar cal = Calendar.getInstance();
String startDate ="2015-05-05";
String endDate ="2015-05-04";
SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
Date dt = new Date();
cal.setTime(dt);
cal.add(Calendar.DATE, 1);
cal.add(Calendar.DATE, 1);
dt = cal.getTime();
String dd = simpleDateFormat1.format(dt);

int dayDiff = dateDiff.dateDiff(startDate,endDate);*/


/*
 * 
 * 
 * 
 * 
 DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
DateTime dt = new DateTime();
DateTime dtOrg = new DateTime(dt);
DateTime dtPlusOne = dtOrg.plusDays(1);
String dd = fmt.print(dtPlusOne);
 *
 *
 *
 */
