package com.ddlab.rnd.type3;

public class NewLineFormatterTest {

    public static void testFormatText() {

        String testString = " Formatting line 1. Formatting line 2. Formatting line 3.";
        TextFormattable newLineFormatter = new NewLineFormatter();
        // This is as per legacy system
        String resultString = newLineFormatter.formatText(testString);
        System.out.println(resultString);


        CsvFormattable csvFormatter = new CsvFormatter();
        TextFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);
        String resultCsvString = csvAdapter.formatText(testString);
        System.out.println(resultCsvString);



    }

    public static void main(String[] args) throws Exception {
        testFormatText();
    }
}