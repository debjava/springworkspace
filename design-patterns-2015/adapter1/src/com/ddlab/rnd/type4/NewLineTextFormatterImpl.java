package com.ddlab.rnd.type4;

public class NewLineTextFormatterImpl implements TextFormatter {

	@Override
	public String formatText(String text) {
		String formattedText = text.replace(".", "\n");
		return formattedText;
	}

}
