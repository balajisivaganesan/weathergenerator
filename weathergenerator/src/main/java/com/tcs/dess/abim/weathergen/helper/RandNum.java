package com.tcs.dess.abim.weathergen.helper;

public class RandNum {
	//randomly generate values as int or float
	public static int rand_int(String Min, String Max)
    {
         return (int) (Math.random()*(Integer.parseInt(Max)-Integer.parseInt(Min))+Integer.parseInt(Min));
    }
    
    public static float rand_float(String Min, String Max)
    {
    	 return (float) (Math.random()*(Float.parseFloat(Max)-Float.parseFloat(Min)))+Float.parseFloat(Min);
    }
}
