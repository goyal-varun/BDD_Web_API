package com.hcl.baseframework;

import java.util.Random;
import java.util.regex.Pattern;

public class Utilities {

	public static Integer randomNumberGenerator() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return randomInt;
	}

	public static String[] splitStringExtractText(String text, String pattern) {
		String[] stringParts = text.split(Pattern.quote(pattern));
		return stringParts;
	}
}
