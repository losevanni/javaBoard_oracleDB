package utils;

public class XSS {
	public static String xssser(String str) {
		boolean result=true;
		str=str.replaceAll("<", "&lt");
		
		return str;
	}
}
