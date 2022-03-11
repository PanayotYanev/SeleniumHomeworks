package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsAndCategories {
    WebDriver webDriver;
    WebDriverWait wait;
    List<WebElement> menuButtons;

    public ProductsAndCategories(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public CreateNewProduct clickOnCategoriesAndProducts(){
        locateAndClickCategoriesAndProducts();
        return new CreateNewProduct(webDriver, wait);
    }

    private void locateAndClickCategoriesAndProducts(){
        menuButtons = webDriver.findElements(new By.ByClassName("btn-default"));
        WebElement categoriesAndProducts = menuButtons.get(2);
        categoriesAndProducts.click();
    }
}
