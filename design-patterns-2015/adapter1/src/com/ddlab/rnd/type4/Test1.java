package com.ddlab.rnd.type4;


public class Test1 {

	public static void main(String[] args) {
		String testString = " Formatting line 1. Formatting line 2. Formatting line 3.";
		TextFormatter textFormatter = new NewLineTextFormatterImpl();
        // This is as per legacy system
        String resultString = textFormatter.formatText(testString);
        System.out.println(resultString);

	}

}
