package SeleniumThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormsPage {
    public void clickPractiseForm(WebDriver webDriver){
        webDriver.findElement(new By.ByXPath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li")).click();
        ExpectedConditions.urlContains("https://demoqa.com/automation-practice-form");
    }
}