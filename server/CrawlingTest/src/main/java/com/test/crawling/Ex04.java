package com.test.crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex04 {

	public static void main(String[] args) {

		try {

			String url = "http://localhost:8090/crawling/ex01.do";
//			Document doc = Jsoup.connect(url).get();
//
//			Elements list = doc.select("#items .item");
//
//			System.out.println(list.size());
//
//			for (Element item : list) {
//				System.out.println(item.text());
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//셀레니움
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\OneDrive\\class\\dev\\chromedriver.exe";

		System.setProperty(webDriverID, path);

		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		
		//브라우저 참조 객체
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://localhost:8090/crawling/ex01.do";
		
		driver.get(url);
		
		WebElement title = driver.findElement(By.id("title"));
		System.out.println(title.getText());

		List<WebElement> list = driver.findElements(By.className("item"));
		
		for (WebElement item : list) {
			System.out.println(item.getText());
		}
		
	} //main

}
