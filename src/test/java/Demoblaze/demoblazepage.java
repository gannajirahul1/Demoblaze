package Demoblaze;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class demoblazepage extends mainClass{
	

	
	@Test(priority=1)
	public void childPage() throws InterruptedException
	{
		//clicking on laptop
		driver.findElement(By.xpath("//a[normalize-space()='Nokia lumia 1520']")).click();
		Thread.sleep(2000);
		//going to add to cart page
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
		Thread.sleep(2000);
		//accepting an alert
		driver.switchTo().alert().accept();
		//after accepting alert going to cart section and placing an order
		
		//clicking on cart section
		driver.findElement(By.xpath("//a[@id='cartur']")).click();
		Thread.sleep(2000);
		//place the order
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		Thread.sleep(2000);
		
		System.out.println("Title is:"+driver.getTitle());
		//after placeing an order we need to enter some values regarding user details
		
		//enetring name	
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Rahul gannaji");
		//entering country
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		//entering city
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Nizamabad");
		//entering credit card number
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("6589856912344321");
		//entring month
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("02");
		//entering year
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2024");
		//clicking on purchase button
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
		
		//after enter the details validating taking screenshots of the page
		
		//validating the details
		//verifying logo
		WebElement logo=driver.findElement(By.xpath("//div[@class='sa-icon sa-success animate']"));
		System.out.println(logo.isDisplayed());
		
		WebElement title=driver.findElement(By.xpath("//div[@class='sa-icon sa-custom']"));
		System.out.println(title.isEnabled());
		
		
		//taking screen shot 
		
		WebElement ts=driver.findElement(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']"));
		
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File tagetplace=new File(System.getProperty("user.dir")+"//ScreenShots//conf.png");
		
		srcfile.renameTo(tagetplace);
		
		//after the details
		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
		
	}
	
	@Test(priority=2)
	public void signup() throws InterruptedException
	{
		
		//clicking on sigup button
		driver.findElement(By.xpath("//a[@id='signin2']")).click();
		Thread.sleep(2000);
		//enter the details
		driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys("rahul g");
		driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys("1234567892");
		
		driver.findElement(By.xpath("//button[@onclick='register()']")).click();

		//after the entering details you need to accept alert
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@fdprocessedid='fx4adg']")).click();
		
	}
	@Test(priority=3)
	public void login() throws InterruptedException
	{
		//clicking on login button
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		Thread.sleep(2000);
		//entering username
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("rahul128");
		Thread.sleep(2000);
		//entering password
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("rahul1");
		Thread.sleep(2000);
		//clicking on login button
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		Thread.sleep(5000);
		//accepting alert
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
	}
	@Test(dependsOnMethods= {"login"})
	public void validation()
	{
		WebElement title=driver.findElement(By.xpath("//a[@id='nameofuser']"));
		System.out.println(title);
		
		
	}

}
