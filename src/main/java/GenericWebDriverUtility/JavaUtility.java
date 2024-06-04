package GenericWebDriverUtility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import GenericFileUtility.FileUtility;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber =random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		Date date =new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String simdate=sim.format(date);
		return simdate;
		
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		
		Date date =new Date();

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(date);

		 Calendar cal =sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, days);
		 String RequiredDate = sim.format(cal.getTime());
		 
		return RequiredDate;
	}
}
