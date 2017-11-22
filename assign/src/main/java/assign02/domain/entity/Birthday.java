package assign02.domain.entity;

import java.util.Calendar;
import java.util.Date;

public class Birthday {

	private Date birthday;
	
	private int yearAge;
	
	public Birthday(String birthday) {
		//
		String year = birthday.substring(0, 4);
		String month = birthday.substring(5, 6);
		String day = birthday.substring(7, 8);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(year));
		calendar.set(Calendar.MONTH, Integer.valueOf(month)-1);
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
		
		this.birthday = calendar.getTime();
		
		calculateAge();
	}
	
	public Birthday(Date birthday) {
		//
		this.birthday = birthday;
		calculateAge();
	}
	
	private void calculateAge() {
		//
		Calendar birthdayCal = Calendar.getInstance();
		birthdayCal.setTime(birthday);
		
		Calendar todayCal = Calendar.getInstance();
		
		yearAge = todayCal.get(Calendar.YEAR) - birthdayCal.get(Calendar.YEAR);
	}

	public Date getBirthday() {
		return birthday;
	}

	public int getYearAge() {
		return yearAge;
	}
}
