package com.goma.readimage;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="JSESSIONID=22C228672BABD4DE447D014CFA1B5088; Path=/";
		System.out.println(s.substring(s.indexOf("=")+1,s.indexOf(";")));
		System.out.println("22C228672BABD4DE447D014CFA1B5088");

	}

}
