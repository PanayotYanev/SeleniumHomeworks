package SeleniumFive;

import SeleniumFive.DemoQA.DemoQA_Alert;
import SeleniumFive.DemoQA.DemoQA_browserWindows;
import SeleniumFive.IFrame.IFrame;
import SeleniumFive.TablePress.TablePress;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumFive {
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

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Test
    public void testSwitchToFrame() {
        IFrame iFrame = new IFrame(webDriver);

        iFrame.searchForSeleniumInTheSearchBox(webDriver, wait);
        iFrame.moveAroundDifferentPages(webDriver, wait);
    }

    @Test
    public void testDemoQAOne() {
        DemoQA_Alert demoQA_alert = new DemoQA_Alert(webDriver);

        demoQA_alert.acceptThePopUpAlert(webDriver, wait);
    }

    @Test
    public void testDemoQATwo() {
        DemoQA_browserWindows demoQA_browserWindows = new DemoQA_browserWindows(webDriver);

        demoQA_browserWindows.printTextFromAnotherWindow(webDriver);
    }

    @Test
    public void testTablePressPrintPage() {
        TablePress tablePress = new TablePress(webDriver);
        tablePress.printOnWhichTablePageWeAre(webDriver);
    }

    @Test
    public void testTablePressPrintTableContent() {
        TablePress tablePress = new TablePress(webDriver);
        tablePress.printTheContentOfTheTable(webDriver);
    }

    @Test
    public void testTablePressPrintLastNamesOfPeopleInTheTable() {
        TablePress tablePress = new TablePress(webDriver);
        tablePress.printLastNames();
    }

    @Test
    public void testTablePressPrintZipCode() {
        TablePress tablePress = new TablePress(webDriver);
        tablePress.printZipCode();
    }

    @Test
    public void testTablePressPrintPoints() {
        TablePress tablePress = new TablePress(webDriver);
        tablePress.printPoints();
    }

    @AfterMethod
    public void quitWebDriver(){
        webDriver.quit();
    }
}
