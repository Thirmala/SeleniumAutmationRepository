package GenericUtilityContact;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SupportDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
System.out.println(	date.toString());	

SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

 String actDate  =sim.format(date);
 
 Calendar cal =sim.getCalendar();
 cal.add(Calendar.DAY_OF_MONTH, 30);
 String DateAfter30Days = sim.format(cal.getTime());
 System.out.println(DateAfter30Days);
 
 
 
}

}
