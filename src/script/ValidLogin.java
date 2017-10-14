package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{

	@Test(priority=1,groups={"login","smoke"})
	public void testValidLogin()
	{
//		String un=Lib.getCellValue(XL_PATH,"ValidLogin",1,0);
//		String pw=Lib.getCellValue(XL_PATH,"ValidLogin",1,1);
//		String title=Lib.getCellValue(XL_PATH,"ValidLogin",1,2);
//		String sETO = Lib.getProperty(CONFIG_PATH,"ETO");
//		long lETO = Long.parseLong(sETO);
//		Enter valid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName("admin");
//		Enter valid password
		l.setPassword("manager");
//		click on login
		l.clickLogin();
//		verify Home page is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver,"actiTIME - Enter Time-Track",10);
	}
}








