/**
 * 
 */
package com.adapter;

/**
 * THis is the client class
 * 
 * @author Idiotechie
 * 
 */
public class EuropeanPlugPointClient {

	public static void main(String[] args) {
		PlugConverter targetInterface = new EuropeanAdapter();
		System.out.println("Now the European plugpoint connects with"
				+ targetInterface.getEuropePlug());

	}

}
