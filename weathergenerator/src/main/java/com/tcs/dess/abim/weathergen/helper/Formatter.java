package com.tcs.dess.abim.weathergen.helper;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

	
	static DecimalFormat form = new DecimalFormat("0.0");
	
	public static String date_format(Date date)
	{
	//formats the date to ISO8601 format
	DateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    return dt.format(date);
	}
	
	public static String check_sym(float value)
	{
	//returns the float with "+" for positive values
		
	String strValue = form.format(value);
	return (String) (value > 0 ? "+"+strValue : ""+strValue);
	}
	
	public static String check_precision(float value)
	{
	return form.format(value);
	}
}
