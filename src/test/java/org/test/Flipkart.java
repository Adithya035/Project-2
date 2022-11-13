package org.test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Flipkart {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Login = driver.findElement(By.xpath("//button[text()='✕']"));
		Login.click();
		WebElement Search = driver.findElement(By.name("q"));
		Search.sendKeys("Laptops",Keys.ENTER);
		System.out.println("Page 1 Laptop Product names");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (WebElement x : findElements) {
			String text = x.getText();
			System.out.println(text);
		}
		System.out.println("Total Size is ");
		int size = findElements.size();
		System.out.println(size);
		System.out.println("Page 1 Laptop Price List");
		List<WebElement> Price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (WebElement y : Price) {
			String text = y.getText();
			if(text.contains("₹")) {
				text = text.replace("₹", "");
			}
			if(text.contains(",")) {
				text = text.replace(",", "");
			}
			int it = Integer.parseInt(text);
			System.out.println(it);
		}
		System.out.println("Total Size is ");
		int size1 = findElements.size();
		System.out.println(size1);
		List<Integer> li = new LinkedList<>();
		li.add(59000);
		li.add(67490);
		li.add(28990);
		li.add(32990);
		li.add(36999);
		li.add(49990);
		li.add(47990);
		li.add(47990);
		li.add(38799);
		li.add(87990);
		li.add(42990);
		li.add(85990);
		li.add(61999);
		li.add(48990);
		li.add(31021);
		li.add(29990);
		li.add(61990);
		li.add(42990);
		li.add(28990);
		li.add(67990);
		li.add(57890);
		li.add(28129);
		li.add(61990);
		li.add(44490);
		System.out.println(li);
		System.out.println("Ascending Order of Laptop Price");
		Collections.sort(li);
		System.out.println(li);
		System.out.println("Maximum Price of the Laptop is "+Collections.max(li));
		System.out.println("Minimum Price of the Laptop is "+Collections.min(li));
	}
}