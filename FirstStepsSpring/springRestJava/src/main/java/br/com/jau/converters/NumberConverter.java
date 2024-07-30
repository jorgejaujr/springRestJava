package br.com.jau.converters;

public class NumberConverter {

	public static Double convertToDouble(String srtNumber) {
		if (srtNumber == null) return 0D;
		String number = srtNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return null;
	}


	public static boolean isNumeric(String srtNumber) {
		if (srtNumber == null) return false;
		String number = srtNumber.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
		
	};


}
