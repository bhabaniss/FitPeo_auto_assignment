package assesmentfitpeo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {

	public static void main(String[] args) {
		
		
		WebDriver driver= new ChromeDriver();
		
		//Navigate to the FitPeo Home page
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigate to the Revenue Calculator Page
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		
		//Scroll down to the slider section
		JavascriptExecutor scrolljs = (JavascriptExecutor)driver;
		WebElement scroll = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1pr1g5o']"));
		scrolljs.executeScript("arguments[0].scrollIntoView()", scroll);
		
		//Adjust the slider
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 94, 0).perform();
		
		scrolljs.executeScript("arguments[0].scrollIntoView()", scroll);
		
		//Update the text Field
		WebElement sendtext = driver.findElement(By.xpath("//input[@type='number']"));
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys("560");
		
		//update back to the actual value i.e= 820
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys(Keys.BACK_SPACE);
		sendtext.sendKeys("820");
		
		//Select CPT Codes
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div[2]//label[1]//span[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]")).click();
		driver.findElement(By.xpath("//div[8]//label[1]//span[1]//input[1]")).click();
		
		//get the Total Recurring Reimbursement for all Patients Per Month:
		WebElement totalvalue = driver.findElement(By.xpath("//header/div[1]/p[4]/p[1]"));
		
		//validate the Total Recurring Reimbursement for all Patients Per Month:
		String actvalue=totalvalue.getText();
		String curvalue="$110700";
		if(actvalue.equals(curvalue)) {
			System.out.println("The Expected value and the actual value are same");
		}

		driver.close();
		
		
		
	}

}
