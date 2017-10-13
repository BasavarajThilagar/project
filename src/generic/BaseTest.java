package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
    public WebDriver driver;
    static{
    	System.setProperty(CHROME_KEY,CHROME_VALUE);
    	System.setProperty(GECKO_KEY, GECKO_VALUE);
    }
    @Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String node,String browser) throws Exception{
		URL remote=new URL(node);
		DesiredCapabilities d=new DesiredCapabilities();
		d.setBrowserName(browser);
		driver=new RemoteWebDriver(remote,d);
		String url = Lib.getProperty(CONFIG_PATH,"URL");
		driver.get(url);
		String sITO = Lib.getProperty(CONFIG_PATH,"ITO");
		long lITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(lITO,TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication(){
		driver.quit();
	}
}









