package com.test.project;

import com.github.lalyos.jfiglet.FigletFont;

public class Test {
	
	public static void main(String[] args) {

		try {

			String asciiArt3 = FigletFont.convertOneLine(".\\font\\banner3.flf", "hello");
		    System.out.println(asciiArt3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main

}