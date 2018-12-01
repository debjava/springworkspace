package com.ddlab.rnd.type4;

public class Test2 {
	
	public static void getOutput() {
		
		CSVFormatter csvFormatter = new CSVFormatterImpl();
		TextFormatter textFormatter = new CSVAdapterFormatter(csvFormatter);
		String testString = " Formatting line 1. Formatting line 2. Formatting line 3.";
		
		String result = textFormatter.formatText(testString);
		System.out.println(result);
	}

	public static void main(String[] args) {
		
		getOutput();

	}

}
