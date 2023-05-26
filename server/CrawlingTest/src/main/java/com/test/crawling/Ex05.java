package com.test.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex05 {

	public static void main(String[] args) {

		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\OneDrive\\class\\dev\\chromedriver.exe";

		System.setProperty(webDriverID, path);

		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		
		//브라우저 참조 객체
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
		
		driver.get(url);
		
		//아이디, 비밀번호
		WebElement id = driver.findElement(By.id("strLoginID"));
		id.sendKeys("한효원");
		
		WebElement pw = driver.findElement(By.id("strLoginPwd"));
		pw.sendKeys("0473");
		
		WebElement btn = driver.findElement(By.cssSelector("#content > div > form > table > tbody > tr > td > div > div.login-form > div.login-btn > input"));
		btn.click();
		
		//딜레이
		try {
			
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement period = driver.findElement(By.cssSelector("#content > div > div > div > div.panel-body > form > table > thead > tr:nth-child(5) > td:nth-child(2)"));
		System.out.println("period:" + period.getText());

	} //main
	
}
