package SeleniumTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumHomeworkTwo {
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
        String firstWebElement = webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5"))
                .getText();
        System.out.println(firstWebElement);

        String secondWebElement = webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]/h5"))
                .getAccessibleName();
        System.out.println(secondWebElement);

        String thirdWebElement = webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[3]/div/div[3]/h5"))
                .getAccessibleName();
        System.out.println(thirdWebElement);
    }

    @Test
    public void testTwo() {
        webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[1]")).click();
        Assert.assertEquals("https://demoqa.com/elements", webDriver.getCurrentUrl());

        String textBox = webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span")).getText();
        System.out.println(textBox);
    }

    @Test
    public void testThree(){
        webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[6]")).click();
        Assert.assertEquals("https://demoqa.com/books", webDriver.getCurrentUrl());

        List<WebElement> bookTitleElementList = webDriver.findElements(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]"));

        for(WebElement book : bookTitleElementList){
            System.out.println(book.getText());
        }
    }

    @AfterMethod
    public void quitWebDriver(){
        webDriver.quit();
    }
}