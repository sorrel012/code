package com.test.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex04 {

	public static void main(String[] args) {

		try {
			
			String url = "http://localhost:8090/crawling/ex01.do";
			Document doc = Jsoup.connect(url).get();
			
			Elements list = doc.select("#items .item");
			
			System.out.println(list.size());
			
			for (Element item : list) {
				System.out.println(item.text());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main
	
}
