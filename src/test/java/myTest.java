import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTest {
	
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Atul\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		fetchData fd = new fetchData();
		String sheetName = "MyData";
		ArrayList<String> a = fd.fetchExcelData(sheetName);	
		
		driver.get("https://www.facebook.com/");
				
		for(int i=0;i<a.size();i++)
		{
			if(i>0)
			{
				driver.findElement(By.id("email")).sendKeys(a.get(i)+" ");
			}
		}
		
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
			
		}
		
		
	}
	

}
