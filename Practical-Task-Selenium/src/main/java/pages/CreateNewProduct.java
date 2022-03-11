package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateNewProduct {
    WebDriver webDriver;
    WebDriverWait wait;

    public CreateNewProduct(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public EditTablet createNewProduct(String tabletName){
        populateNewProductFields(tabletName);
        return new EditTablet(webDriver);
    }

    private void populateNewProductFields(String nameOfNewTablet){
        WebElement createNewProduct = webDriver.findElement(new By.ByClassName("cus-add"));
        createNewProduct.click();

        Select contentParent = new Select(webDriver.findElement(By.id("ContentParentId")));
        contentParent.selectByVisibleText("Tablets");

        WebElement productTitle = webDriver.findElement(new By.ById("ContentDescription][1][name1"));
        productTitle.sendKeys(nameOfNewTablet);

        webDriver.switchTo().frame("content_description_1_ifr");
        WebElement productDescription = webDriver.findElement(new By.ById("tinymce"));
        productDescription.sendKeys("This tablet is shown to withstand from the strongest attacks. That's why we ironically named it crack");

        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame("content_short_description_1_ifr");
        WebElement shortenedProductDescription = webDriver.findElement(new By.ById("tinymce"));
        shortenedProductDescription.sendKeys("This is a indestructible tablet");

        webDriver.switchTo().defaultContent();

        WebElement tab = webDriver.findElement(new By.ById("myTab"));
        List<WebElement> dataTabs = tab.findElements(new By.ByTagName("li"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", dataTabs.get(1).findElement(new By.ByTagName("a")));

        Select productLabel = new Select(webDriver.findElement(new By.ById("ContentProductLabelId")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", productLabel);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(new By.ById("ContentProductLabelId"))));
        productLabel.selectByVisibleText("New");

        WebElement submitButton = webDriver.findElement(new By.ById("submitbutton"));
        submitButton.click();
    }
}
