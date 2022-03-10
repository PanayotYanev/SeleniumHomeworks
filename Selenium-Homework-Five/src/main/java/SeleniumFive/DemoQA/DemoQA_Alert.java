package SeleniumFive.DemoQA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQA_Alert {
    public DemoQA_Alert(WebDriver webDriver) {
        webDriver.get("https://demoqa.com/alerts");
    }

    public void acceptThePopUpAlert(WebDriver webDriver, WebDriverWait wait){
        Alert alert = clickTheConfirmButton(webDriver, wait);

        alert.accept();
    }

    public void declineThePopUpAlert(WebDriver webDriver, WebDriverWait wait){
        Alert alert = clickTheConfirmButton(webDriver, wait);

        alert.dismiss();
    }

    private Alert clickTheConfirmButton(WebDriver webDriver, WebDriverWait wait){
        WebElement confirmButton = webDriver.findElement(new By.ById("confirmButton"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", confirmButton);

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();

        return alert;
    }
}
