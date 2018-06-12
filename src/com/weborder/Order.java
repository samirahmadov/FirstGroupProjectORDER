package com.weborder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/samirahmadov/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester"); 
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Order")).click();
		Thread.sleep(1000);
		String a= String.valueOf(randomNum());
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),a);
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + randomIdentifier() + " Smith" );
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st" );
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown" );
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia" );
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode() );

		final int cardType= getRandomInteger(1,3); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='ctl00$MainContent$fmwOrder$cardList'])["+cardType+"]")).click();
		
		switch(cardType) {
		case 1: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+randomCard(16) ); break; 
		case 2: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+randomCard(16)  ); break;
		case 3: driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+randomCard(15)  ); break;
		}
		Thread.sleep(1000);	
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("05/23" );
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	    
	}
		public static int randomNum() {
			
			Random rn = new Random();
			int random = rn.nextInt(100);
			return  random; 
	
		}
		public static String zipCode() {
			
			Random rn = new Random();
			int random = rn.nextInt(10);
			int randomfirst=rn.nextInt(9)+1; 
			String zipcode=""+randomfirst+random+random+random+random; 
			return  zipcode; 
	
		}	
		public static String randomCard(int num) {
			
			Random rn = new Random();
			String card=""; 
			for (int i = 0; i < num-1; i++) {
				int random = rn.nextInt(10); 
			    card=card+random;  
				
			}
			return  card; 
	
		}
		public static String randomIdentifier() {
			
			final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			Random rn = new Random();
			int random1 = rn.nextInt(24);
			
		    return lexicon.charAt(random1) + "";
		    
		}
		private static int getRandomInteger(int min, int max){
			
		    return ThreadLocalRandom.current().nextInt(min, max+1);
		}

}
