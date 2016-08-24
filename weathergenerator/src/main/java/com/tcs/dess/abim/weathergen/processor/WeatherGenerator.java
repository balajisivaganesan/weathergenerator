package com.tcs.dess.abim.weathergen.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import com.tcs.dess.abim.weathergen.helper.*;
import com.tcs.dess.abim.weathergen.model.Conditions;
import com.tcs.dess.abim.weathergen.model.Conditionslist;
import com.tcs.dess.abim.weathergen.model.Locations;
import com.tcs.dess.abim.weathergen.model.Locationslist;
import com.tcs.dess.abim.weathergen.constants.*;
/**
 * 
 * @author Balaji Sivaganesan. This program simulates weather conditions in
 *         around 11 places in Australia with details of Lat, Long, Elevation,
 *         weather condition, temperature, pressure and humidity
 * 
 *         The places that are output from simulator are available in the
 *         resource folder. It is configurable to change. The simulation is done
 *         create various weather conditions like snow, rain, cloudy, clear and
 *         sunny
 *
 **/
public class WeatherGenerator extends Thread {
	public static void main(String[] args) throws IOException {

		WeatherGenerator obj = new WeatherGenerator();

		Locationslist loclist = new Locationslist();
		Conditionslist condlist = new Conditionslist();
		Random rand = new Random();

		// Reads the files containing location details and weather condition
		// details and load to a bean
		// Eg.Melbourne,-37.82,144.95,9 (City,Lat,Long,Elevation)
		// Eg.Rain,+10,+20,1005,1010,90,100
		// (Weather,Temphigh,Templow,Pressurehigh,Pressurelow,humidityhigh,humiditylow)
		obj.readFiles("location.txt", "conditions.txt", loclist, condlist);

		int loop_const = 0;
		
		File file = new File("./bin/weatheroutput.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
	
		// The loop to decide how many values to be generated
		while (loop_const < 10) {
			// reads the location details and keeps on repeating the values
			for (int j = 0; j < loclist.getLocationlist().size(); j++) {

				StringBuilder resultString = new StringBuilder();

				resultString.append(loclist.getLocationlist().get(j).getCity() + Constants.PIPE_SPLITTER);
				resultString.append(loclist.getLocationlist().get(j).getLatitude() + Constants.COMMA_SPLITTER);
				resultString.append(loclist.getLocationlist().get(j).getLongitude() + Constants.COMMA_SPLITTER);
				resultString.append(loclist.getLocationlist().get(j).getElevation() + Constants.PIPE_SPLITTER);
				resultString.append(RandDate.rand_date() + Constants.PIPE_SPLITTER);

				// randomly select the climate either
				// sunny,rain,snow,cloudy,clear etc.
				// The file in the resource folder can be edited to make changes
				int x = rand.nextInt(condlist.getConditionlist().size());

				resultString.append(condlist.getConditionlist().get(x).getWeather_state() + Constants.PIPE_SPLITTER);

				// randomly generate values for temp,pressure,humidity based on
				// high/low values specified.
				resultString
						.append(Formatter.check_sym(RandNum.rand_float(condlist.getConditionlist().get(x).getTemp_low(),
								condlist.getConditionlist().get(x).getTemp_high())) + Constants.PIPE_SPLITTER);
				resultString.append(
						Formatter.check_precision(RandNum.rand_float(condlist.getConditionlist().get(x).getPres_low(),
								condlist.getConditionlist().get(x).getPres_high())) + Constants.PIPE_SPLITTER);
				resultString.append(RandNum.rand_int(condlist.getConditionlist().get(x).getHumd_low(),
						condlist.getConditionlist().get(x).getHumd_high()) + "\n");

				System.out.print(resultString);
				// The values are written to a file to be created in bin folder
				bw.write(resultString.toString());
				
				// if there is no wait required, comment out this section
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			loop_const++;
		}
		bw.close();
	}

	public void readFiles(String locFile, String condFile, Locationslist loclist, Conditionslist condlist)
			throws FileNotFoundException {

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();

		File locfile = new File(classLoader.getResource(locFile).getFile());
		File condfile = new File(classLoader.getResource(condFile).getFile());

		try {

			Scanner locscanner = new Scanner(locfile);
			Scanner condscanner = new Scanner(condfile);

			List<Locations> loctlist = new ArrayList<Locations>();
			List<Conditions> condtlist = new ArrayList<Conditions>();

			while (locscanner.hasNextLine()) {
				// set the bean for the locations
				loctlist.add(SetLoc.setLocation(locscanner.nextLine()));
			}

			while (condscanner.hasNextLine()) {
				// set the bean for the conditions
				condtlist.add(SetCond.setCondition(condscanner.nextLine()));
			}

			// load the list of values to the location and the condition list
			// bean
			loclist.setLocationlist(loctlist);
			condlist.setConditionlist(condtlist);

			locscanner.close();
			condscanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
