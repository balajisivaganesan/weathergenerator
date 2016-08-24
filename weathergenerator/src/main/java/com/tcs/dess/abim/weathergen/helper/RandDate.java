package com.tcs.dess.abim.weathergen.helper;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Balaji Sivaganesan. randomly generate date with the current date as
 *         base
 */
public class RandDate {

	public static String rand_date() {

		Random rand = new Random();
		long t1 = System.currentTimeMillis() + rand.nextInt();
		long t2 = t1 + 2 * 60 * 1000 + rand.nextInt(60 * 1000) + 1;
		Date d2 = new Date(t2);
		return Formatter.date_format(d2);
	}
}
