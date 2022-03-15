package SeleniumThree;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHomeworkThree {
    WebDriver webDriver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(" https://demoqa.com/");
        webDriver.manage().window().maximize();

    }

    @Test
    public void testOne(){
        HomePage homePage = new HomePage();
        homePage.navigateToForms(webDriver);

        FormsPage formsPage = new FormsPage();
        formsPage.clickPractiseForm(webDriver);

        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.fillCredentialsOfStudent(webDriver);
    }


    @AfterMethod
    public void closePage(){
        webDriver.quit();
    }
}