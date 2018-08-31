package com.poj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





import com.detail.Login;
import com.detail.Signin;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
    
    public class Obj {
    	
    	public static WebDriver driver;
    	 
    	@BeforeClass
    	public void open() {
    	 driver=new FirefoxDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	   }
         /*Home_Page hg=new Home_Page(driver);
         LogIn_Page lg=new LogIn_Page(driver);
         hg.sign_in.click();
         lg.uname.sendKeys("testuser_1");
         lg.pwd.sendKeys("Test@123");
         lg.login.click();*/
         @Test(dataProvider="empLogin")
     	public void VerifyInvalidLogin(String userName, String password) throws IOException {
        	  driver.get("http://www.store.demoqa.com");
        	
        	  Signin hg=new Signin(driver);
              Login lg=new Login(driver);
              hg.sign_in.click();
              lg.uname.sendKeys(userName);
              lg.pwd.sendKeys(password);
              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              //The below method will save the screen shot in d drive with name "screenshot.png"
                 FileUtils.copyFile(scrFile, new File("C:\\Users\\srinivas\\Desktop\\obj.png"));
              lg.login.click();
              
     	}
     	@DataProvider(name="empLogin")
     	public Object[][] loginData() {
     		Object[][] arrayObject = getExcelData("C:/Users/srinivas/Desktop/tarun.xls","srini");
     		return arrayObject;
     	}

     	/**
     	 * @param File Name
     	 * @param Sheet Name
     	 * @return
     	 */
     	public String[][] getExcelData(String fileName, String sheetName) {
     		String[][] arrayExcelData = null;
     		try {
     			FileInputStream fs = new FileInputStream(fileName);
     			Workbook wb = Workbook.getWorkbook(fs);
     			Sheet sh = wb.getSheet(sheetName);

     			int totalNoOfCols = sh.getColumns();
     			int totalNoOfRows = sh.getRows();
     			
     			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
     			
     			for (int i= 1 ; i < totalNoOfRows; i++) {

     				for (int j=0; j < totalNoOfCols; j++) {
     					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
     				}

     			}
     		} catch (FileNotFoundException e) {
     			e.printStackTrace();
     		} catch (IOException e) {
     			e.printStackTrace();
     			e.printStackTrace();
     		} catch (BiffException e) {
     			e.printStackTrace();
     		}
     		return arrayExcelData;
     	}

     	@Test
     	public void tearDown() {
     		driver.quit();
     	
   
        }
    }
