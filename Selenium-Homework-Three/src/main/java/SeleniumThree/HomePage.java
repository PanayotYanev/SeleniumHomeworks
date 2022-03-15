package SeleniumThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {
    public void navigateToForms(WebDriver webDriver){
        webDriver.findElement(new By.ByXPath("//html/body/div[2]/div/div/div[2]/div/div[2]")).click();
        ExpectedConditions.urlContains("https://demoqa.com/forms");
    }
}