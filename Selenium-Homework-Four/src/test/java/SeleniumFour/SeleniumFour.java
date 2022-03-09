package SeleniumFour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SeleniumFour {
    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/automation-practice-form");

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Test
    public void testRadioButtonLocatorAndClicker() {
        List<WebElement> radioButtons = webDriver.findElements(new By.ByName("gender"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", radioButtons.get(0));

        for(WebElement webElement : radioButtons){
            if(!webElement.isEnabled()){
                ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", webElement);
                break;
            }
        }
    }

    @Test
    public void testSelectMusicButtonChecker() {
        WebElement musicButton = webDriver.findElement(new By.ById("hobbies-checkbox-3"));
        if(!musicButton.isEnabled()){
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", musicButton);
        }
    }

    @Test
    public void testFindWidgetsAndPrintAllSelectMenuOptions() {
        WebElement widgetButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/span/div/div[1]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", widgetButton);
        widgetButton.click();

        WebElement selectMenuButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[9]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", selectMenuButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", selectMenuButton);

        WebElement oldSelectMenu = webDriver.findElement(new By.ById("oldSelectMenu"));
        Select select = new Select(oldSelectMenu);

        List<WebElement> oldSelectMenuValues = select.getOptions();
        for (WebElement webElement : oldSelectMenuValues){
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void testSelectRandomElementFromDropDownMenu() {
        WebElement widgetButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/span/div/div[1]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", widgetButton);
        widgetButton.click();

        WebElement selectMenuButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[9]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", selectMenuButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", selectMenuButton);

        WebElement oldSelectMenu = webDriver.findElement(new By.ById("oldSelectMenu"));
        Select select = new Select(oldSelectMenu);

        List<WebElement> oldSelectMenuValues = select.getOptions();
        select.selectByIndex(ThreadLocalRandom.current().nextInt(oldSelectMenuValues.size()));
    }

    @Test
    public void testNavigateToAlertsFrameAndWindowsAndPrintAlertMessage() {
        WebElement alertsFrameAndWindowsButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[1]"));
        alertsFrameAndWindowsButton.click();

        WebElement alertsButton = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", alertsButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", alertsButton);

        WebElement timerAlertButton = webDriver.findElement(new By.ById("timerAlertButton"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", timerAlertButton);

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        System.out.println(alert.getText());
    }

    @Test
    public void testCreateNewUserError() {
        webDriver.get("https://demoqa.com/login");

        WebElement newUserButton = webDriver.findElement(new By.ById("newUser"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", newUserButton);
        Assert.assertEquals("https://demoqa.com/register", webDriver.getCurrentUrl());

        WebElement firstName = webDriver.findElement(new By.ById("firstname"));
        firstName.sendKeys("Panayot");

        WebElement lastName = webDriver.findElement(new By.ById("lastname"));
        lastName.sendKeys("Yanev");

        WebElement userName = webDriver.findElement(new By.ById("userName"));
        userName.sendKeys("Yanpa");

        WebElement password = webDriver.findElement(new By.ById("password"));
        password.sendKeys("123456");

        WebElement registerButton = webDriver.findElement(new By.ById("register"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", registerButton);

        WebElement redText = webDriver.findElement(new By.ById("name"));
        System.out.println(redText.getText());
    }

    @Test
    public void testLogInAsUser() {
        webDriver.get("https://demoqa.com/login");

        String userName = "Yanpa";
        String password = "@123Panayot";

        WebElement userNameField = webDriver.findElement(new By.ById("userName"));
        userNameField.sendKeys(userName);

        WebElement passwordField = webDriver.findElement(new By.ById("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = webDriver.findElement(new By.ById("login"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", loginButton);

        wait.until(ExpectedConditions.urlContains("profile"));
        Assert.assertEquals("https://demoqa.com/profile", webDriver.getCurrentUrl());

        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/label[2]"))));
        WebElement userNameValue = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/label[2]"));
        Assert.assertEquals(userNameValue.getText(), userName);
        System.out.println("You tried to log in with username : " + userName);
        System.out.println("You are logged in with username: " + userNameValue.getText());

        WebElement goToStore = webDriver.findElement(new By.ById("gotoStore"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", goToStore);
        wait.until(ExpectedConditions.urlContains("books"));
        Assert.assertEquals("https://demoqa.com/books", webDriver.getCurrentUrl());


        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/span/a")));

        WebElement javaScripDesignPatterns = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/span/a"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", javaScripDesignPatterns);

        if(javaScripDesignPatterns.isDisplayed()){
            WebElement logOutButton = webDriver.findElement(new By.ById("submit"));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", logOutButton);

            Assert.assertEquals("https://demoqa.com/login", webDriver.getCurrentUrl());
            System.out.println("We are logged out of the page");
        }
    }

    @AfterMethod
    public void closePage(){
        webDriver.quit();
    }
}