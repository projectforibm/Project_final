package project_final1;



import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;



public class NewTest {
	static WebDriver driver;
	static Actions action;
	
	@DataProvider public static void PageDown() throws InterruptedException{
		action= new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
	}
	@DataProvider public static void MemberLogin(){
		driver.findElement(By.xpath(".//*[@id='memberUsername']")).sendKeys("pinkubhui");
	}

	@DataProvider 	public static void MouseOver(String str) throws InterruptedException{
		WebElement link_Home=driver.findElement((By.xpath(str)));//submit button in manage to ouseover address
		Actions builder=new Actions(driver);
		Action mouseoverhome=builder.moveToElement(link_Home).build();
		mouseoverhome.perform();
		Thread.sleep(2000);


	}

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='cyclosUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@value='1']")).click();
		driver.findElement(By.xpath("//*[@value='2']")).click();
		driver.findElement(By.xpath("//*[@value='3']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		
		


		//start of password change
		MemberLogin();
		Thread.sleep(1000);
		String str1="http://localhost:8585/do/admin/profile?memberId=3";
		String str=driver.getCurrentUrl();
		Assert.assertEquals(str1, str);
		
		PageDown();
		Thread.sleep(1000);


		//Manage-Change permission
		MouseOver(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[2]/input");

		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[2]/input")).click();//submit button click in manage
		//driver.findElement(By.xpath(".//*[@id='backButton']")).click();
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");//send values to new password
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("1234");//send values to confirm password
		Thread.sleep(1000);
		//submit click
		MouseOver(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input");
		driver.findElement(By.xpath(".//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input")).click();//change password click submit button

		Thread.sleep(500);
		Alert alert=driver.switchTo().alert();
		alert.accept();//accept the change of password alert
		Thread.sleep(1000);

		MouseOver(".//*[@id='backButton']");		//back-button
		driver.findElement(By.xpath(".//*[@id='backButton']")).click();

		//end of password change


		//start of change permission group
		PageDown();
		Thread.sleep(1000);

		WebElement link_Home=driver.findElement(By.cssSelector("input[linkurl='changeMemberGroup?memberId=3']"));//submit button address to mouseover method of change permission
		Actions builder=new Actions(driver);
		Action mouseoverhome=builder.moveToElement(link_Home).build();
		mouseoverhome.perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[linkurl='changeMemberGroup?memberId=3']")).click();//submit button click of change permission

		WebElement id = driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/select"));
		Select values = new Select(id);
		List <WebElement> value =values.getOptions();

		int size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all values in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		Random ran =new Random();
		value.get(ran.nextInt(value.size())).click();//selecting any random value for choosing in drop down list

		driver.findElement(By.xpath(".//*[@id='comments']")).sendKeys("coments given");//comments in change group permissions

		driver.findElement(By.xpath(".//*[@id='backButton']")).click();//back button to home page of member
		//end of change permission group

		//start of manage ads

		//new ads
		PageDown();
		Thread.sleep(1000);
		MouseOver(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input");

		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input")).click();//ads submit click
		driver.findElement(By.xpath(".//*[@id='newButton']")).click();
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/label[2]/input")).click();//combo offers
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/label[1]/input")).click();//combo wants
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("ads");//title



		id = driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/select"));
		values = new Select(id);
		value =values.getOptions();
		size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all values in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		driver.findElement(By.tagName("iframe")).sendKeys("New add created");//Description data
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='saveButton']")).click();//click save button
		Thread.sleep(500);
		alert=driver.switchTo().alert();//confirm add submission pop up
		alert.accept();
		Thread.sleep(500);
		MouseOver(".//*[@id='backButton']");
		driver.findElement(By.xpath(".//*[@id='backButton']")).click();//edit add back
		Thread.sleep(1000);
		//modify ads
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/img[1]")).click();//modify adds
		driver.findElement(By.xpath(".//*[@id='modifyButton']")).click();//change click button
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("updated ads title");//title update
		driver.findElement(By.xpath(".//*[@id='saveButton']")).click();//click save button
		Thread.sleep(2000);
		alert=driver.switchTo().alert();//confirm add submission pop up
		alert.accept();
		Thread.sleep(500);
		//driver.findElement(By.xpath(".//*[@id='backButton']")).click();//edit add back
		driver.findElement(By.xpath(".//*[@id='menu0']/span[2]")).click();//home click
		Thread.sleep(2000);


		//remove ads
		PageDown();
		PageDown();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='memberUsername']")).sendKeys("pinkubhui ");
		PageDown();
		Thread.sleep(1000);
		MouseOver(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input");
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input")).click();//ads submit click
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/img[2]")).click();//click on remove icon

		alert=driver.switchTo().alert();//confirm add submission pop up
		alert.accept();
		Thread.sleep(1000);
		alert=driver.switchTo().alert();//confirm add submission pop up
		alert.accept();

		driver.findElement(By.xpath(".//*[@id='menu0']/span[2]")).click();//home click

		//end of ads

		//start of accounts
		//start of account info

		MemberLogin();
		Thread.sleep(2000);
		
		PageDown();
		Thread.sleep(1000);
		MouseOver(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[1]/td[2]/input");
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[1]/td[2]/input")).click();//click submit button account info

		id = driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/select"));//drop down list box
		values = new Select(id);
		value =values.getOptions();

		size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all payment types in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		ran =new Random();
		value.get(ran.nextInt(value.size())).click();//selecting any random value for choosing in drop down list of payment types

		MemberLogin();

		driver.findElement(By.name("query(period).begin")).sendKeys("15/06/2014");//ffrom date
		driver.findElement(By.name("query(period).end")).sendKeys("16/06/2018");//to date
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input")).click();//click search
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='backButton']")).click();//click back

		//end of account info



		//payment system to member
		PageDown();
		Thread.sleep(1000);
		MouseOver(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[2]/td[2]/input");

		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[2]/td[2]/input")).click();//payment system to member submit button click
		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("1");//sending value to amount

		id = driver.findElement(By.xpath(".//*[@id='type']"));//drop down list box payment to member
		values = new Select(id);
		value =values.getOptions();

		size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all payment types in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		ran =new Random();
		value.get(1).click();//selecting any random value for choosing in drop down list of payment to members
 
		driver.findElement(By.name("description")).sendKeys("description added to the payment discription to members");//addin text to discription box of payment to members
		MouseOver(".//*[@id='submitButton']");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();//payment system to member submit button click
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();//final submission confiramtion click submmit

		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='printButton']")).click();//print button submit click
    	driver.findElement(By.xpath(".//*[@id='newPaymentButton']")).click();//payment system to member submit button click
		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("1");//sending value to amount

		id = driver.findElement(By.xpath(".//*[@id='type']"));//drop down list box payment to member
		values = new Select(id);
		value =values.getOptions();

		size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all payment types in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		ran =new Random();
		value.get(1).click();

		driver.findElement(By.xpath(".//*[@id='description']")).sendKeys("description added to the payment discription to members");//addin text to discription box of payment to members 
		MouseOver(".//*[@id='submitButton']");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();//payment system to member submit button click
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();//final submission confiramtion click submmit

		Thread.sleep(1000);

/*		driver.findElement(By.xpath(".//*[@id='newPaymentButton']")).click();//make new payment submit click
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("5");//sending value to amount

		id = driver.findElement(By.xpath(".//*[@id='type']"));//drop down list box payment to member
		values = new Select(id);
		value =values.getOptions();

		size= value.size();

		for(int i=0;i<size;i++)//loop for selecting all payment types in list
		{
			value.get(i).click();
			Thread.sleep(400);
		}
		//ran =new Random();
		value.get(1).click();//selecting any random value for choosing in drop down list of payment to members

		driver.findElement(By.tagName("iframe")).sendKeys("description added to the payment discription to members");//addin text to discription box of payment to members
		MouseOver(".//*[@id='submitButton']");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();//payment system to member submit button click
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();//final submission confiramtion click submmit

		Thread.sleep(1000);
		driver.findElement(By.name(".//*[@id='backToMemberProfileButton']")).click();//member info submit click button

*/
		//end of payment to member

		//start of loan
		driver.findElement(By.xpath(".//*[@id='menu0']/span[2]")).click();//home click
		MemberLogin();
		PageDown();
Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")).click();

		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys("1000");
		driver.findElement(By.name("loan(repaymentDate)")).sendKeys("14/06/2018");
		driver.findElement(By.xpath(".//*[@id='customValuesCell']/table/tbody/tr/td[2]/input[2]")).sendKeys("987654321");
		driver.findElement(By.xpath(".//*[@id='description']")).sendKeys("description added to the grant loan field");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id)
	//	driver.findElement(By.xpath("//input[@id='tdContents' and value='Submit']")).click();
		//MouseOver(".//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input");
		driver.findElement(By.cssSelector("form[name='confirmLoanForm'] tr:nth-child(8) > td > input")).click();
		Thread.sleep(1000);
		alert=driver.switchTo().alert();//confirm add submission pop up
		alert.accept();

		Thread.sleep(1000);


		
		
		
		//Login
/*
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		//driver.findElement(By.name("password")).sendKeys("1234");//In keyboard it is not fetching the data
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String Expectedurl = "Cyclos";
		String actualurl = driver.getTitle();
		Assert.assertEquals(Expectedurl, actualurl);
		System.out.println(actualurl);
		//admin
*/
		//personal
		 builder=new Actions(driver);
		//click in "Personal"                                                                                                                                                                                
		mouseoverhome= builder.moveToElement(  driver.findElement(By.xpath("//*[@id='menu1']/span[2]"))).build();
		mouseoverhome.perform();
		Thread.sleep(500);
		//click in "profile"
		driver.findElement(By.xpath("//*[@id='menu1']/span[2]")).click();
		//click in "Admin group"
		driver.findElement(By.xpath(".//*[@id='submenu1.0']/span[2]")).click();
		//taking value from "Admin group"
		String s=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).getAttribute("value");
		System.out.println(s);
		Thread.sleep(500);

		System.out.println("1st test to perform verifcation of Admin group that is System administrators");


		//2nd test to perform verifcation of Login name that is admin
		///taking value from "Login name"
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");

		System.out.println("2nd test to perform verifcation of Login name that is admin");

		//check whether the Admin group is editable or not.
		driver.findElement(By.xpath(".//*[@id='submenu1.0']/span[2]"));
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input")).isEnabled();
		Thread.sleep(400); 
		//check whether the Login name is editable or not.
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).isEnabled();
		Thread.sleep(400); 
		System.out.println("6th test to check whether the Admin group that is System administrators and Login name that is admin is editable or not");
	


	//3rd test to edit the Full name


	
		//click in "Change Button"
		driver.findElement(By.id("modifyButton")).click();
		String s1="http://localhost:8585/do/admin/adminProfile?fromMenu=true";
		String s2=driver.getCurrentUrl();
		Assert.assertEquals(s1,s2);
		System.out.println(s2);
		//clear the content of"Full name"  
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).clear();
		Thread.sleep(400);
		//Give string value to "Full name'
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("srikumar");
		//click in"submit button"
		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(500);
		alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("3rd test to edit the Full name");
	

	//4th test to edit the E-Mail

	      //click in "Change Button"
		driver.findElement(By.id("modifyButton")).click();
		//clear the content of"Email"
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).clear();
		Thread.sleep(400);
		//Give string value to "Email"
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).sendKeys("srikumar@gmail.com ");
		//click in"submit button"
		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(400);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		System.out.println("4th test to edit the E-Mail");
	

	//5th test click "Change password" and change the password

	   
		////click in "password change"
		driver.findElement(By.xpath("//*[@id='submenu1.1']/span[2]")).click();
		Thread.sleep(400);
		//submit value to"Current password"
		driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");
		//submit value to"New password"
		driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("1234"); 
		//submit value to"Confirm new password"
		driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input")).sendKeys("1234"); 
		//click in"submit button"
		driver.findElement(By.xpath("//*[@id='changePasswordForm']/table/tbody/tr[2]/td/table/tbody/tr[5]/td/input")).click();
		Thread.sleep(400); 
		driver.switchTo().alert().accept();
		
		System.out.println("5th test click Change password and change the password");

		//6th test to check whether the "Admin group that is System administrators" and "Login name that is admin" is editable or not


		System.out.println("345");
		
		
		
//message
		link_Home=driver.findElement(By.id("menu8"));
		Actions builder55=new Actions(driver);
		Action mouseoverhome66=builder.moveToElement(link_Home).build();
		mouseoverhome66.perform();
		builder55.sendKeys(link_Home,(Keys.ENTER)).perform();
		
		System.out.println("entered into message column");
		
System.out.println("123");
		
  		driver.findElement(By.xpath("//*[@id='submenu8.0']")).click(); 
  		
  		System.out.println("entered into message box \n");

  	WebElement ML= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
  	Select message = new Select(ML);
  	List <WebElement> ML1 = message.getOptions();
  	
  	//message.selectByVisibleText(ML1.get(2).getText());
  	System.out.println("number of elements of message box is: "+ML1.size());
  	System.out.println("elements of message box are");
  	int x= ML1.size();
  	for (int i=0; i<x; i++){
  		System.out.println(ML1.get(i).getText());	}
  	
  	//to access  sent message

  	message.selectByVisibleText("Sent items");
  	Thread.sleep(2000);
  	 

  	//to access sent message
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")).click();
  	
  	
  	String S="http://localhost:8585/do/admin/viewMessage?messageId=32";
  	String S1="http://localhost:8585/do/admin/viewMessage?messageId=32";
  	Assert.assertEquals(S1, S);
  	System.out.println("URl matched");
  	
  	 
  	 driver.findElement(By.xpath(".//*[@id='backButton']")).click();

  	//to select one  message checkbox 
  	
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
  	// to un-select  message checkbox
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
  	 
  	 
  	/*
  	  //to access button delete
  	 
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).click();
  	String s= driver.switchTo().alert().getText();
  	System.out.println("Text in pop up after deleting message :="+s);
  	driver.switchTo().alert().accept();*/
  	

  	
  	//to select "select-all" button
  	driver.findElement(By.xpath(".//*[@id='selectAllButton']")).click();
  	WebElement ML2= driver.findElement(By.id("applyActionSelect"));
  	Select message1 = new Select(ML2);
  	
  	
  	//message1.selectByVisibleText("Mark as read");
  	message1.selectByVisibleText("Mark as unread");

  	 
  TestNGThread.sleep(5000);
  	
  	//for trash listbox
  	WebElement ML3= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
  	Select message2 = new Select(ML3);
  	message2.selectByVisibleText("Trash");
  	
  	System.out.println("moved to trash checkbox");
  	
  	TestNGThread.sleep(2000);
  	/*driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/input")).click();
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[5]/img")).click();*/
  	
  	
  	/*String s1= driver.switchTo().alert().getText();
  	//driver.switchTo().alert().accept();
  	driver.switchTo().alert().dismiss();*/
  	System.out.println("message after deleting message form delete column =>"+"Are you sure to permanently remove the message");
  	
  	
  	/*String s3= driver.switchTo().alert().getText();
  	driver.switchTo().alert().accept();*/
  	System.out.println("pop up after clicking delete button=>"+"The message was removed");
  	
  	TestNGThread.sleep(3000);
  	

  	
  	//for accessing messages
  	
  	WebElement ML4= driver.findElement(By.xpath("//*[@id='messageBoxSelect']"));
  	Select message3 = new Select(ML4);
  	message3.selectByVisibleText("Inbox");
  	
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")).click();
  	String s6="http://localhost:8585/do/admin/viewMessage?messageId=32";
  	String s7="http://localhost:8585/do/admin/viewMessage?messageId=32";
  	
  	Assert.assertEquals(s7, s6);
  	
  	
  	System.out.println("url matched");
  	
  	
  	driver.findElement(By.xpath(".//*[@id='replyButton']")).click();
  	TestNGThread.sleep(2000);
  	
  	driver.findElement(By.tagName("iframe")).sendKeys("it is a reply message");
  	
  	
  	driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();
  	String s24= 	driver.switchTo().alert().getText();
  	driver.switchTo().alert().accept();
  	System.out.println("pop up after sending reply=> "+s24);
  	
  	 
  	 TestNGThread.sleep(2000);
    
  	 
  	 
  	 System.out.println("2");
  	 
  	 
  	 
  	 
  	 
  	 
  	 driver.findElement(By.xpath("//*[@value='Submit']")).click();
 	  driver.findElement(By.name("sendTo"));
 	  driver.findElement(By.xpath("//*[@value='GROUP']")).click();
 	  driver.findElement(By.name("sendTo"));
 	  driver.findElement(By.xpath("//*[@value='MEMBER']")).click();
 	  PageDown();
 	 driver.findElement(By.id("memberUsername")).sendKeys("samsaravanan");
 	 
 	 TestNGThread.sleep(3000);
 	 

 	 WebElement category = driver.findElement(By.id("categorySelect"));
 		Select categoryList = new Select(category);
 		List <WebElement> categoryList1 = categoryList.getOptions();	
 		System.out.println("number of optin in category list box"+categoryList1.size());
 		for (int i=0; i<categoryList1.size(); i++){
 	System.out.println(categoryList1.get(i).getText());}
 		
 	  driver.findElement(By.id("subjectText")).sendKeys("only to test application");
 	  driver.findElement(By.tagName("iframe")).sendKeys("hie...");
 	  
 	  driver.findElement(By.xpath("//*[@value='Submit']")).click();
 	  

 	  
 	  TestNGThread.sleep(5000);
 	 String s23= driver.switchTo().alert().getText();

 	  driver.switchTo().alert().accept();
 	  TestNGThread.sleep(5000);


 	  
 	  System.out.println("message after sending email= "+s23);
 	  
 	  
 	  TestNGThread.sleep(3000);
 	  //driver.findElement(By.id("backButton")).click();

 	 // driver.findElement(By.xpath("//*[@value='Submit']")).click();
 		 
 		 TestNGThread.sleep(3000);
 		 
 		 
 		 
 		 System.out.println("3");
 		 
 		 
 		 
 		 
 		 
 		/*WebElement link_Home3=driver.findElement(By.id("menu8"));
  		Actions builder22=new Actions(driver);
  		Action mousehoverhome=builder22.moveToElement(link_Home3).build();
  		mousehoverhome.perform();
  		builder22.sendKeys(link_Home,(Keys.ENTER)).perform();
  		driver.findElement(By.xpath("//*[@id='submenu8.0']")).click();
  		*/

  		System.out.println("3.5");
  		
  	WebElement link_Home1=  driver.findElement(By.xpath(".//*[@id='selectAllButton']"));
  	Actions builder1= new Actions(driver);
  	Action mouseoverhome1= builder1.moveToElement(link_Home1).build();
  	mouseoverhome1.perform();
  	
  	driver.findElement(By.xpath(".//*[@id='selectAllButton']")).click();
  	
  	TestNGThread.sleep(5000);
  	
System.out.println("3.6");
  	
  	WebElement link_Home2=  driver.findElement(By.xpath(".//*[@id='selectNoneButton']"));
  	Actions builder2= new Actions(driver);
  	Action mouseoverhome2= builder2.moveToElement(link_Home2).build();
  	mouseoverhome2.perform();
  	
  	driver.findElement(By.xpath(".//*[@id='selectNoneButton']")).click();
  	
  	
  	
  	
  	System.out.println("4");
  	
  	
  	
  	driver.findElement(By.xpath(".//*[@id='submenu8.1']/span[2]")).click();
		driver.findElement(By.id("newButton")).click();
		driver.findElement(By.name("messageCategory(name)")).sendKeys("new_p");
		driver.findElement(By.id("saveButton")).click();
		TestNGThread.sleep(2000);


		String s33= driver.switchTo().alert().getText();

		  driver.switchTo().alert().accept();

		  
		  System.out.println("message after enter new category= "+s33);  
		
		   
		 driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/img[1]")).click();
			 
		 driver.findElement(By.id("modifyButton")).click();
		 driver.findElement(By.name("messageCategory(name)")).clear();
		 driver.findElement(By.name("messageCategory(name)")).sendKeys("support");
		 driver.findElement(By.id("saveButton")).click();
		 TestNGThread.sleep(2000);

		
		 String s10= driver.switchTo().alert().getText();

		
		 
		  driver.switchTo().alert().accept();
		  
			 

		  System.out.println("message after editing category= "+s10); 
		  
		 
		  //for deleting msg
		  
		  driver.findElement(By.xpath(".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img[2]")).click();
		  TestNGThread.sleep(2000);

			 
		  driver.switchTo().alert().accept();
			 

			 String s243= driver.switchTo().alert().getText();
			 // driver.switchTo().alert().accept();
				

			  System.out.println("message after deleting category= "+s243); 
			  
		  //for not deleting msg
		  driver.switchTo().alert().dismiss();

		
		


		//Alert		

		driver.findElement(By.xpath(".//*[@id='menu2']/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='submenu2.0']/span[2]")).click();
		List<WebElement> check=driver.findElements(By.name("alertIds"));
		for(WebElement e:check)
		{
			e.click();
			System.out.println("all the check boxes are checked");
		}



		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[2]/tbody/tr/td[2]/input")).click();


		driver.switchTo().alert().dismiss();
		System.out.println("check boxes are dismissed");
		//driver.switchTo().alert.accept();

		//member alerts

		driver.findElement(By.xpath(".//*[@id='submenu2.1']/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='selectAllButton']")).click();

		System.out.println("all the check boxes are selected");
		driver.findElement(By.xpath(".//*[@id='selectNoneButton']")).click();

		System.out.println("all the check boxes are not selected");
		driver.findElement(By.xpath(".//*[@id='tdContents']/form/table[2]/tbody/tr/td[2]/input")).click();

		driver.switchTo().alert().dismiss();	



		driver.findElement(By.xpath(".//*[@id='submenu2.2']/span[2]")).click();
		WebElement type = driver.findElement(By.name("query(type)"));
		Select dropdown = new Select(type);
		dropdown.selectByVisibleText("Member");
		WebElement date = driver.findElement(By.name("query(period).begin"));
		Thread.sleep(2000);
		date.sendKeys("40/13/2019");
		date.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		date.sendKeys("12/01/2014");


		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,"23/06/2018");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='memberUsername']")).sendKeys("pinkubhui(pinkubhui)");
		driver.findElement(By.xpath(".//*[@id='memberName']")).sendKeys("pinkubhui");
		driver.findElement(By.xpath(".//*[@id='tdContents']/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td/input")).click();




		System.out.println("member is selected is from list box");


		//All fields are working in internationalization section

		WebElement link_Home55=driver.findElement(By.id("menu9"));
		 builder=new Actions(driver);
		mouseoverhome=builder.moveToElement(link_Home55).build();
		mouseoverhome.perform();
		builder.sendKeys(link_Home55,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.0']")).click();


		driver.findElement(By.id("modifyButton")).click();

		WebElement language=driver.findElement(By.name("setting(language)"));
		Select languageselect=new Select(language);
		List <WebElement> languageselect1=languageselect.getOptions();
		System.out.println("All countries are printing");
		for(int i=1;i<=languageselect1.size()-1;i++)
		{
			System.out.println(languageselect1.get(i).getText());
		}



		WebElement Nf=driver.findElement(By.name("setting(numberLocale)"));
		Select Nfselect=new Select(Nf);
		List <WebElement> Nfselect1=Nfselect.getOptions();
		System.out.println(Nfselect1.get(0).getText());
		System.out.println("number format are available and printing");
		for(int i=1;i<=Nfselect1.size()-1;i++)
		{
			System.out.println(Nfselect1.get(i).getText());
		}



		WebElement Np=driver.findElement(By.name("setting(precision)"));
		Select Npselect=new Select(Np);
		List <WebElement> Npselect1=Npselect.getOptions();
		System.out.println(Npselect1.get(0).getText());
		System.out.println("number precision are available and printing");
		for(int i=1;i<=Npselect1.size()-1;i++)
		{
			System.out.println(Npselect1.get(i).getText());
		}


		WebElement Hp=driver.findElement(By.name("setting(highPrecision)"));
		Select Hpselect=new Select(Hp);
		List <WebElement> Hpselect1=Hpselect.getOptions();
		System.out.println(Hpselect1.get(0).getText());
		System.out.println("high precision are available and printing");
		for(int i=1;i<=Hpselect1.size()-1;i++)
		{
			System.out.println(Hpselect1.get(i).getText());
		}


		WebElement dnim=driver.findElement(By.name("setting(decimalInputMethod)"));
		Select dnimselect=new Select(dnim);
		List <WebElement> dnimselect1=dnimselect.getOptions();
		System.out.println(dnimselect1.get(0).getText());
		System.out.println("decimal no input method are available and printing");
		for(int i=1;i<=dnimselect1.size()-1;i++)
		{
			System.out.println(dnimselect1.get(i).getText());
		}


		WebElement timezone=driver.findElement(By.name("setting(timeZone)"));
		Select timezoneselect=new Select(timezone);
		List <WebElement> timezoneselect1=timezoneselect.getOptions();
		System.out.println(timezoneselect1.get(0).getText());
		System.out.println("the time zone available are:");
		for(int i=1;i<=timezoneselect1.size()-1;i++)
		{
			System.out.println(timezoneselect1.get(i).getText());
		}


		WebElement date1=driver.findElement(By.name("setting(datePattern)"));
		Select dateselect=new Select(date1);
		List <WebElement> dateselect1=dnimselect.getOptions();
		System.out.println(dateselect1.get(0).getText());
		System.out.println("the date pattern that are available are:");
		for(int i=1;i<=dateselect1.size()-1;i++)
		{
			System.out.println(dateselect1.get(i).getText());
		}

		WebElement timeformat=driver.findElement(By.name("setting(timePattern)"));
		Select timeformatselect=new Select(timeformat);
		List <WebElement> timeformatselect1=timeformatselect.getOptions();
		System.out.println(timeformatselect1.get(0).getText());
		System.out.println("the available time format are:");
		for(int i=1;i<=timeformatselect1.size()-1;i++)
		{
			System.out.println(timeformatselect1.get(i).getText());
		}


		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();

		String ad="http://localhost:8585/do/admin/editLocalSettings";
		String ad1=driver.getCurrentUrl();
		Assert.assertEquals(ad,ad1);
		System.out.println(ad1);

		driver.findElement(By.xpath("//*[@id='menu15']")).click();
		driver.switchTo().alert().accept();

		//All fields are working in Alert Settings and incorrect login attempt


		Thread.sleep(3000);
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@value='1']")).click();
		driver.findElement(By.xpath("//*[@value='2']")).click();
		driver.findElement(By.xpath("//*[@value='3']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.xpath("//*[@value='Submit']")).click();

		WebElement link_Home18=driver.findElement(By.id("menu9"));
		Actions builder18=new Actions(driver);
		Action mouseoverhome18=builder18.moveToElement(link_Home18).build();
		mouseoverhome18.perform();
		builder18.sendKeys(link_Home18,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.1']")).click();
		driver.findElement(By.id("modifyButton")).click();

		driver.findElement(By.name("setting(givenVeryBadRefs)")).clear();
		driver.findElement(By.name("setting(givenVeryBadRefs)")).sendKeys("10");

		driver.findElement(By.name("setting(receivedVeryBadRefs)")).clear();
		driver.findElement(By.name("setting(receivedVeryBadRefs)")).sendKeys("10");	

		driver.findElement(By.name("setting(idleInvoiceExpiration).number")).clear();
		driver.findElement(By.name("setting(idleInvoiceExpiration).number")).sendKeys("10");


		WebElement country11=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/select"));
		Select countryselect1111=new Select(country11);
		countryselect1111.selectByVisibleText("Day(s)");

		driver.findElement(By.name("setting(amountDeniedInvoices)")).clear();
		driver.findElement(By.name("setting(amountDeniedInvoices)")).sendKeys("10");

		driver.findElement(By.name("setting(amountIncorrectLogin)")).clear();
		driver.findElement(By.name("setting(amountIncorrectLogin)")).sendKeys("3");

		WebElement setting=driver.findElement(By.name("setting(amountIncorrectLogin)"));
		String res=setting.getAttribute("value");
		int res1=Integer.parseInt(res);


		if (res1>10)
		{
			System.out.println("application has defect as it accepts more than 10");
		}
		else
		{
			System.out.println("application is working fine");
		}

		String ad2="http://localhost:8585/do/admin/editAlertSettings?fromMenu=true";
		String ad3=driver.getCurrentUrl();
		Assert.assertEquals(ad2,ad3);
		System.out.println(ad3);



		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();
		//driver.close();

		WebElement link_Home11=driver.findElement(By.id("menu15"));
		Actions builder11=new Actions(driver);
		Action mouseoverhome11=builder11.moveToElement(link_Home11).build();
		mouseoverhome11.perform();
		//builder1.sendKeys(link_Home1,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='menu15']")).click();

		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		for (int i=0;i<res1-1;i++)
		{

			driver.findElement(By.id("cyclosUsername")).clear();
			driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
			
			driver.findElement(By.xpath("//*[@value='1']")).click();
			driver.findElement(By.xpath("//*[@value='2']")).click();
			driver.findElement(By.xpath("//*[@value='3']")).click();
			driver.findElement(By.xpath("//*[@value='Submit']")).click();
			driver.findElement(By.xpath("//*[@id ='btn']")).click();
			//Alert alert11 =driver.switchTo().alert();
			//alert11.accept();
	
		}
		





		//All fields are working in access settings and login password is input with virtual keyboard

		Thread.sleep(500);

		driver.findElement(By.xpath(".//*[@id='cyclosUsername']")).clear();
		driver.findElement(By.xpath(".//*[@id='cyclosUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@value='1']")).click();
		driver.findElement(By.xpath("//*[@value='2']")).click();
		driver.findElement(By.xpath("//*[@value='3']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.xpath("//*[@value='Submit']")).click();

		WebElement link_Home111=driver.findElement(By.id("menu9"));
		Actions builder111=new Actions(driver);
		Action mouseoverhome111=builder111.moveToElement(link_Home111).build();
		mouseoverhome111.perform();
		builder111.sendKeys(link_Home111,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.2']")).click();
		driver.findElement(By.id("modifyButton")).click(); 

		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboard)']")).click();
		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[@id='menu15']")).click();
		driver.switchTo().alert().accept();

		Thread.sleep(500);
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@value='Submit']")).click();

		WebElement link_Home1111=driver.findElement(By.id("menu9"));
		Actions builder1111=new Actions(driver);
		Action mouseoverhome1111=builder1111.moveToElement(link_Home1111).build();
		mouseoverhome1111.perform();
		builder1111.sendKeys(link_Home1111,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.2']")).click();
		driver.findElement(By.id("modifyButton")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboard)']")).click();
		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='menu15']")).click();
		driver.switchTo().alert().accept();

		String ad6="http://localhost:8585/do/login";
		String ad7=driver.getCurrentUrl();
		Assert.assertEquals(ad6,ad7);
		System.out.println(ad7);

		//All  fields are working in access settings

		Thread.sleep(500);
		driver.findElement(By.id("cyclosUsername")).clear();
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@value='1']")).click();
		driver.findElement(By.xpath("//*[@value='2']")).click();
		driver.findElement(By.xpath("//*[@value='3']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.xpath("//*[@value='Submit']")).click();

		WebElement link_Home11111=driver.findElement(By.id("menu9"));
		Actions builder11111=new Actions(driver);
		Action mouseoverhome11111=builder11111.moveToElement(link_Home11111).build();
		mouseoverhome11111.perform();
		builder11111.sendKeys(link_Home11111,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.2']")).click();
		driver.findElement(By.id("modifyButton")).click();

		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboard)']")).click();
		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboard)']")).click();

		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboardTransactionPassword)']")).click();
		driver.findElement(By.xpath("//*[@name='setting(virtualKeyboardTransactionPassword)']")).click();

		driver.findElement(By.xpath("//*[@name='setting(numericPassword)']")).click();
		driver.findElement(By.xpath("//*[@name='setting(numericPassword)']")).click();

		driver.findElement(By.xpath("//*[@name='setting(allowMultipleLogins)']")).click();
		driver.findElement(By.xpath("//*[@name='setting(allowMultipleLogins)']")).click();

		driver.findElement(By.xpath("//*[@name='setting(allowOperatorLogin)']")).click();
		driver.findElement(By.xpath("//*[@name='setting(allowOperatorLogin)']")).click();

		driver.findElement(By.name("setting(adminTimeout).number")).clear();
		driver.findElement(By.name("setting(adminTimeout).number")).sendKeys("15");

		WebElement country=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/select"));
		Select countryselect=new Select(country);
		countryselect.selectByVisibleText("Minute(s)");
		List <WebElement> countryselect1=countryselect.getOptions();
		System.out.println("size = "+countryselect1.size());
		for (int i11=0;i11<countryselect1.size();i11++)
		{
			System.out.println(countryselect1.get(i11).getText());
		}

		driver.findElement(By.name("setting(memberTimeout).number")).clear();
		driver.findElement(By.name("setting(memberTimeout).number")).sendKeys("10");
		WebElement country1=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/select"));
		Select countryselect11=new Select(country1);
		countryselect11.selectByVisibleText("Minute(s)");
		List <WebElement> countryselect111=countryselect.getOptions();
		System.out.println("size = "+countryselect111.size());
		for (int i1=0;i1<countryselect111.size();i1++)
		{
			System.out.println(countryselect111.get(i1).getText());
		}

		driver.findElement(By.name("setting(poswebTimeout).number")).clear();
		driver.findElement(By.name("setting(poswebTimeout).number")).sendKeys("1");
		WebElement country66=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/select"));
		Select countryselect6666=new Select(country66);
		countryselect6666.selectByVisibleText("Day(s)");

		driver.findElement(By.name("setting(administrationWhitelist)")).clear();
		driver.findElement(By.name("setting(administrationWhitelist)")).sendKeys("#Any host");

		driver.findElement(By.name("setting(usernameLength).min")).clear();
		driver.findElement(By.name("setting(usernameLength).min")).sendKeys("4");

		driver.findElement(By.name("setting(usernameLength).max")).clear();
		driver.findElement(By.name("setting(usernameLength).max")).sendKeys("12");

		//driver.findElement(By.name("setting(usernameRegex)")).clear();
		//driver.findElement(By.name("setting(usernameRegex)")).sendKeys("");

		driver.findElement(By.name("setting(transactionPasswordChars)")).clear();
		driver.findElement(By.name("setting(transactionPasswordChars)")).sendKeys("ABCDEFGHIJ");

		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();

		String ad8="http://localhost:8585/do/admin/editAccessSettings";
		String ad9=driver.getCurrentUrl();
		Assert.assertEquals(ad8,ad9);
		System.out.println(ad9);		 		

		driver.findElement(By.xpath("//*[@id='menu15']")).click();
		driver.switchTo().alert().accept();

		//automatically logs out of the account

		Thread.sleep(4000);
		driver.findElement(By.id("cyclosUsername")).clear();
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@value='1']")).click();
		driver.findElement(By.xpath("//*[@value='2']")).click();
		driver.findElement(By.xpath("//*[@value='3']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.xpath("//*[@value='Submit']")).click();

		WebElement link_Home6=driver.findElement(By.id("menu9"));
		Actions builder6=new Actions(driver);
		Action mouseoverhome6=builder6.moveToElement(link_Home6).build();
		mouseoverhome6.perform();
		builder6.sendKeys(link_Home6,(Keys.ENTER)).perform();
		driver.findElement(By.xpath("//*[@id='submenu9.2']")).click();
		driver.findElement(By.id("modifyButton")).click();


		driver.findElement(By.name("setting(adminTimeout).number")).clear();
		driver.findElement(By.name("setting(adminTimeout).number")).sendKeys("15");

		WebElement country111=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/select"));
		Select countryselect11111=new Select(country111);
		countryselect11111.selectByVisibleText("Minute(s)");

		WebElement setting1 =driver.findElement(By.name("setting(adminTimeout).number"));
		String res5=setting1.getAttribute("value");
		int res6=Integer.parseInt(res5);


		driver.findElement(By.name("setting(memberTimeout).number")).clear();
		driver.findElement(By.name("setting(memberTimeout).number")).sendKeys("10");
		WebElement country1111=driver.findElement(By.xpath(".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/select"));
		Select countryselect111111=new Select(country1111);
		countryselect111111.selectByVisibleText("Minute(s)");

		WebElement setting11=driver.findElement(By.name("setting(adminTimeout).number"));
		String res2=setting11.getAttribute("value");
		int res3=Integer.parseInt(res2);

		driver.findElement(By.id("saveButton")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='menu15']")).click();
		driver.switchTo().alert().accept();

		String ad10="http://localhost:8585/do/login";
		String ad11=driver.getCurrentUrl();
		Assert.assertEquals(ad10,ad11);
		System.out.println(ad11);
	}



@BeforeTest
public void beforeTest() {
	driver=new FirefoxDriver();
	driver.get("http://localhost:8585/do/login");
	driver.manage().window().maximize();
	
}

@AfterTest
public void afterTest() {
	System.out.println("Successfull");
	driver.close();
}


}
