package com.practice.hacerrank;

public class DayOfProgrammer {

	public static void main(String[] args) {
		String dayOfProgrammer = dayOfProgrammer(1918);
		String dayOfProgrammer2 = dayOfProgrammerOtherApproach(2016);
		// System.out.println(dayOfProgrammer);
		// System.out.println(dayOfProgrammer2);
		//122129406
		int seat = saveThePrisoner(1    , 1    , 1);
		System.out.println(seat);
	}

	public static int saveThePrisoner(int prisoners, int sweets, int seat) {
		int curr_pos = (sweets % prisoners) - 1 + seat;
		if (curr_pos==0)
				return prisoners;
		curr_pos = curr_pos > prisoners ? curr_pos - prisoners : curr_pos;
		return curr_pos;
	}

	public static String dayOfProgrammer(int year) {
		String dayOfProgrammer = "";
		Boolean isLeapYear = false;
		if (year <= 1917 && year >= 1700) {
			if (year % 4 == 0) {
				isLeapYear = true;
			}
		} else {
			if (year == 1918) {
				dayOfProgrammer = "26.09.1918";
				return dayOfProgrammer;
			} else {
				if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
					isLeapYear = true;
				}
			}
		}

		if (isLeapYear) {
			dayOfProgrammer = "12.09.";
		} else {
			dayOfProgrammer = "13.09.";
		}
		dayOfProgrammer += year;

		return dayOfProgrammer;
	}

	public static String dayOfProgrammerOtherApproach(int year) {

		int mon7 = 215;
		String dayOfProgrammer = "";

		int feb = 0;
		if (year < 1918)
			feb = (year % 4 == 0) ? 28 : 29;
		else if (year > 1918)
			feb = !(year % 400 == 0) || (year % 100 != 0 && (year % 4 == 0)) ? 29 : 28;
		else // dreaded 1918
			feb = 15;
		feb = 256 - (feb + mon7);
		dayOfProgrammer = feb + ".09." + year;
		return dayOfProgrammer;
	}

}
