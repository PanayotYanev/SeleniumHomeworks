package SeleniumFive.DemoQA;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DemoQA_browserWindows {
    public DemoQA_browserWindows(WebDriver webDriver) {
        webDriver.get(" https://demoqa.com/browser-windows");
    }

    public void printTextFromAnotherWindow(WebDriver webDriver){
        WebElement newWindowButton = webDriver.findElement(new By.ById("windowButton"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", newWindowButton);

        ArrayList<String> windows = new ArrayList<> (webDriver.getWindowHandles());
        webDriver.switchTo().window(windows.get(1));

        WebElement sampleHeading = webDriver.findElement(new By.ById("sampleHeading"));
        System.out.println(sampleHeading.getText());
    }
}
