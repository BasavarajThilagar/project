package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2,groups={"login"},enabled=false)
	public void testInvalidLogin(){
		int rc=Lib.getRowCount(XL_PATH,"InvalidLogin");
		for(int i=1;i<=rc;i++){
		String un=Lib.getCellValue(XL_PATH,"InvalidLogin",i,0);
		String pw=Lib.getCellValue(XL_PATH,"InvalidLogin",i,1);
		//Enter invalid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//verify that err msg is displayed
		l.verifyErrMsgIsDisplayed();
		}
	}
}




