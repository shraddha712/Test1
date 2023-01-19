package TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		LocalDateTime ldt=LocalDateTime.now();
		String timestamp = ldt.toString().replace(':', '-');//we use this bcoz with the help of : we can not save the file so for saving file with timestamp we use replace.
		System.out.println(timestamp);

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		
		TakesScreenshot ts= (TakesScreenshot)driver;//downcasting screenshot.
		
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile= new File("./ErrorShot1/actitime2"+timestamp+".png");
		//tempfile.renameTo(destfile);
		FileUtils.copyFile(tempfile, destfile);//used to create folder automatically.
	
		//FileUtils.copyDirectory(tempfile, destfile);
		/*fileutils:=common i/o tool it is present in 
		third party tool,it creates folder automatically
		*/
	}
		//FileUtils.copyDirectory(tempfile, destfile);
		/*fileutils:=common i/o tool it is present in 
		third party tool,it creates folder automatically
		*/
}
