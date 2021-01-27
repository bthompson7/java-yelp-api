package main.utils;

public class getCurrentDay {

	public getCurrentDay() {

	}

	public int dayOfWeekToInt(String day) {
		switch (day) {
		case "monday":
			return 0;
		case "tuesday":
			return 1;
		case "wednesday":
			return 2;
		case "thursday":
			return 3;
		case "friday":
			return 4;
		case "saturday":
			return 5;
		case "sunday":
			return 6;

		}

		return 0;
	}
}
