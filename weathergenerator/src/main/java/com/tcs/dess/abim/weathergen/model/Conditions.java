package com.tcs.dess.abim.weathergen.model;

public class Conditions {
//Bean for weather conditions
private String weather_state;
private String temp_low;
private String temp_high;
private String pres_low;
private String pres_high;
private String humd_low;
private String humd_high;

public String getWeather_state() {
	return weather_state;
}
public void setWeather_state(String weather_state) {
	this.weather_state = weather_state;
}
public String getTemp_low() {
	return temp_low;
}
public void setTemp_low(String temp_low) {
	this.temp_low = temp_low;
}
public String getTemp_high() {
	return temp_high;
}
public void setTemp_high(String temp_high) {
	this.temp_high = temp_high;
}
public String getPres_low() {
	return pres_low;
}
public void setPres_low(String pres_low) {
	this.pres_low = pres_low;
}
public String getPres_high() {
	return pres_high;
}
public void setPres_high(String pres_high) {
	this.pres_high = pres_high;
}
public String getHumd_low() {
	return humd_low;
}
public void setHumd_low(String humd_low) {
	this.humd_low = humd_low;
}
public String getHumd_high() {
	return humd_high;
}
public void setHumd_high(String humd_high) {
	this.humd_high = humd_high;
}

}
