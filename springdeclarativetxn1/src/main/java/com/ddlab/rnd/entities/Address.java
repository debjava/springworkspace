/**
 * 
 */
package com.ddlab.rnd.entities;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class Address {
	private int id;
	private String adrsDetail;
	private String cityName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdrsDetail() {
		return adrsDetail;
	}
	public void setAdrsDetail(String adrsDetail) {
		this.adrsDetail = adrsDetail;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
 }
