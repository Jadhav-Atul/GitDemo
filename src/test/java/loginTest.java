import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Atul\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		readData testData = new readData();
		ArrayList<String> myData = testData.getData01();
		
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.id("email")).sendKeys(myData.get(1));
		
		for(int i=0;i<myData.size();i++)
		{
			if(i>0)
			{
				driver.findElement(By.id("email")).sendKeys(myData.get(i)+" ");
			}
		}
		

	}

}
