import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form  {
    public static void main(String[] args)throws InterruptedException {

        // Set the property for webdriver.chrome.driver to be the location to your local  download of chromedriver
        System.setProperty("webdriver.chrome.driver", "C://Users//Sameep Hedaoo//Desktop//Selenium//chromedriver_win32//chromedriver.exe");

        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit formy
        driver.get("https://formy-project.herokuapp.com/form");

        submitForm(driver);

        waitForAlertBanner(driver);


        driver.quit();
    }
    public static void submitForm(WebDriver driver) throws InterruptedException
    {
        WebElement name = driver.findElement(By.id("first-name"));
        name.sendKeys("Eren");
        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Jaegar");
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.id("job-title"));
        title.sendKeys("Attack Titan");
        Thread.sleep(1000);

        WebElement education = driver.findElement(By.id("radio-button-2"));
        education.click();
        Thread.sleep(1000);

        WebElement sex = driver.findElement(By.id("checkbox-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sex);
        sex.click();
        Thread.sleep(1000);

        WebElement insideExp = driver.findElement(By.cssSelector("option[value='2']"));
        insideExp.click();
        Thread.sleep(1000);

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("01/20/2002");
        Thread.sleep(1000);

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys(Keys.RETURN);
        Thread.sleep(1000);

        WebElement submit = driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a"));
        submit.click();

    }

    public static void waitForAlertBanner(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
    }
}