

package com.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.emory.mathcs.util.concurrent.TimeoutException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class ExcelDataProvider {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws TimeoutException {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement profileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/me/']")));
		Assert.assertTrue(profileLink.isDisplayed(), "Login successful");
            WebElement loginError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'incorrect') or contains(text(),'wrong')]")));
			Assert.assertTrue(loginError.isDisplayed(), "Error message displayed for failed login");
        }




    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        File file = new File("C:\\eclipse-workspace\\quantumsoft_1\\resources\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    data[i - 1][j] = cell.toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
