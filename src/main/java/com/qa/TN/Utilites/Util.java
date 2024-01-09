package com.qa.TN.Utilites;

import java.util.Date;


public class Util {
	

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", ":").replace(":", "_");
		return "Shiwlee2011" + timeStamp + "@gmail.com";

}
}