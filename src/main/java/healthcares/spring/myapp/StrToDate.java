package healthcares.spring.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StrToDate {
	public Date dateTo(String Date1)
	{

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		DateFormat df2 = new SimpleDateFormat("yyyy"); 
		DateFormat df3 = new SimpleDateFormat("MM-dd"); 
	
    	try {
    		Date dd = df.parse(Date1);
    		String d = df2.format(dd);
    		int d2 = Integer.parseInt(d)+543;
    		String Date2 = Integer.toString(d2)+"-"+df3.format(dd);
			Date date = df.parse(Date2);

			

			return date;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
