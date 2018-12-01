/**
 * 
 */
package com.adapter;

/**
 * This is the adapter class
 * 
 * @author Idiotechie
 * 
 */
public class EuropeanAdapter extends UKPlug implements PlugConverter {

	@Override
	public String getEuropePlug() {
		String cylindricalStem1 = getRectangularStem1();
		String cylindricalStem2 = getRectangularStem2();
		return "converted European Plug Points: "
				+ cylindricalStem1 + " and " + cylindricalStem2;
	}

}
