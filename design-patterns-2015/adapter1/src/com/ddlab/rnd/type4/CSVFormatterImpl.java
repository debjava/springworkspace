package com.ddlab.rnd.type4;

public class CSVFormatterImpl implements CSVFormatter {

	@Override
	public String formatCSV(String text) {
		String formattedText=text.replace(".",",");
		return formattedText;
	}

}
