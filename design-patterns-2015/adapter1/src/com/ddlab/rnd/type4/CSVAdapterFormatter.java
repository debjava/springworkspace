package com.ddlab.rnd.type4;
//Adapter
public class CSVAdapterFormatter implements TextFormatter {
	
	private CSVFormatter csvFormatter;
	
	public CSVAdapterFormatter(CSVFormatter csvFormatter) {
		
		this.csvFormatter = csvFormatter;
	}

	@Override
	public String formatText(String text) {
		
		String formattedText=csvFormatter.formatCSV(text);
        return formattedText;
	}
}
