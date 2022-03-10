package SeleniumFive.IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class IFrame {

    public IFrame(WebDriver webDriver){
        webDriver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        webDriver.switchTo().frame("globalSqa");
    }

    public void moveAroundDifferentPages(WebDriver webDriver, WebDriverWait wait){
        WebElement facebookButton = webDriver.findElement(new By.ByXPath("//*[@id=\"footer\"]/div[2]/div/div/div/div/a[5]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", facebookButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", facebookButton);

        ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));

        wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath(".//h1[contains(text(), 'Globalsqa')]")));
        WebElement facebookPageName = webDriver.findElement(new By.ByXPath(".//h1[contains(text(), 'Globalsqa')]"));
        System.out.println(facebookPageName.getText());


        webDriver.switchTo().window(tabs.get(0));
        WebElement pageHeader = webDriver.findElement(new By.ByXPath(".//h1[contains(text(), 'Frames And Windows')]"));
        System.out.println(pageHeader.getText());

        WebElement footerContainer = webDriver.findElement(new By.ById("footer"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", footerContainer);
        List<WebElement> fourColumns = footerContainer.findElements(new By.ByClassName("four"));
        WebElement textWidget = fourColumns.get(0).findElement(new By.ByClassName("textwidget"));
        System.out.println(textWidget.getText());
    }

    public void searchForSeleniumInTheSearchBox(WebDriver webDriver, WebDriverWait wait){
        WebElement searchBar = webDriver.findElement(new By.ById("s"));
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys("Selenium");

        WebElement searchButton = webDriver.findElement(new By.ByClassName("button_search"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", searchButton);
    }

}
