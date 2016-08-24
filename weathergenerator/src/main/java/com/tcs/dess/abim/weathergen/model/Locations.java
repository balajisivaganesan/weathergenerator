package com.tcs.dess.abim.weathergen.model;

public class Locations {

//Bean to hold details of the city
private String city;
private String latitude;
private String longitude;
private String elevation;

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getElevation() {
	return elevation;
}
public void setElevation(String elevation) {
	this.elevation = elevation;
}

}
