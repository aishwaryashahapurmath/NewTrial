package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AISHWARYA\\eclipse-workspace\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		driver.findElement(By.name("userfile")).click();

		Runtime.getRuntime().exec("E:\\FileUploadScript");

		Thread.sleep(3000);
		//driver.close();

	}

}
