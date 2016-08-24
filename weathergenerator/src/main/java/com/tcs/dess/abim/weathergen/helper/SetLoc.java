package com.tcs.dess.abim.weathergen.helper;

import com.tcs.dess.abim.weathergen.model.Locations;

/**
 * 
 * @author Balaji Sivaganesan. Split the string read from locations file and set
 *         the location bean appropriately
 *
 */

public class SetLoc {

	public static Locations setLocation(String locString) {

		String[] line = locString.split(",");
		Locations loc = new Locations();
		loc.setCity(line[0]);
		loc.setLatitude(line[1]);
		loc.setLongitude(line[2]);
		loc.setElevation(line[3]);
		return loc;
	}
}
