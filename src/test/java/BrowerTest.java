import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowerTest {
	public static void main(String args[]) throws Exception
	{
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+ "/drivers/geckodriver/geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 
        driver.get("https://google.com/");
                
        driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("abcd");
        
        List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
        
        int count = listOfInputElements.size();
        
        System.out.println("Count of Input elements : "+count);
        
        //WebElement textBox = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
        
        //textBox.sendKeys("Automation step by step");
        
        Thread.sleep(3000);
        driver.close();
	}
}
