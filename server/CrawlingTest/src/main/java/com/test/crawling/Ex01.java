package com.test.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex01 {
	
	public static void main(String[] args) {

		//Jsoup
		try {
			
			//Document > 문서 최상위 객체 > 읽어온 페이지 소스를 관리하는 객체
			String url = "http://localhost:8090/crawling/ex01.do";
			Document doc = Jsoup.connect(url).get();
			
			//System.out.println(doc.html());
			
			//Element select(String cssQuery) > css 선택자로 select하여 Element형으로 반환 > 가장 많이 사용!
			
			//doc.select("#title"); //id 선택자 사용
			
			Elements list = doc.select("h1"); //h1태그가 하나밖에 없어서 태그 선택자 사용 가능
			Element h1 = list.get(0);
			
			System.out.println(h1.text()); // > Java Crawling
			
			Elements plist = doc.select(".desc"); //클래스 선택자 사용
			
			for(Element e : plist) {
				System.out.println(e.text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	} //main

}
