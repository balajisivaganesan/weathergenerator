package com.tcs.dess.abim.weathergen.helper;

import com.tcs.dess.abim.weathergen.model.Conditions;

public class SetCond {
	
	//Split the string read from conditions file and set the condition bean appropriately
	public static Conditions setCondition(String condString){
	
	String[] line = condString.split(",");
	Conditions cond = new Conditions();
	cond.setWeather_state(line[0]);
	cond.setTemp_low(line[1]);
	cond.setTemp_high(line[2]);
	cond.setPres_low(line[3]);
	cond.setPres_high(line[4]);
	cond.setHumd_low(line[5]);
	cond.setHumd_high(line[6]);
	return cond;
	}
}