package Demoblaze;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class mainClass {
	public WebDriver driver;

	
	@BeforeClass
	@Parameters({"os","browser"})
	public void Setup(String os,String br) 
	
	{
	//this is chrome options which will disable the "chrome is controlled by autoamtion software"
	ChromeOptions opt=new ChromeOptions();
	opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
	switch(br.toLowerCase())
	{
	case "chrome":driver=new ChromeDriver(opt);
	break;
	case "edge":driver=new EdgeDriver();
	break;
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.demoblaze.com/");
	driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	

}

