package com.tcs.dess.abim.weathergen.model;

import java.util.List;

/**
 * 
 * @author Balaji Sivaganesan.List to hold multiple Condition beans 
 *
 */
public class Conditionslist {
	
	List<Conditions> conditionlist;

	public List<Conditions> getConditionlist() {
		return conditionlist;
	}

	public void setConditionlist(List<Conditions> conditionlist) {
		this.conditionlist = conditionlist;
	}

}
