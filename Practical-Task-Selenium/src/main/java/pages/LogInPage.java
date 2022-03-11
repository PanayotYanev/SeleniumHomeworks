package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    WebDriver webDriver;
    WebDriverWait wait;
    WebElement username;
    WebElement password;
    WebElement logInKey;

    private By usernameLocator = new By.ById("UserUsername");
    private By passwordLocator = new By.ById("UserPassword");
    private By logKeyLocator = new By.ByClassName("cus-key");

    public LogInPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public ProductsAndCategories logIn(String username, String password){
        populateLogInFieldsAndMoveForward(username, password);
        return new ProductsAndCategories(webDriver, wait);
    }

    private void populateLogInFieldsAndMoveForward(String usernamePopulate, String passwordPopulate){
        username = webDriver.findElement(usernameLocator);
        username.sendKeys(usernamePopulate);

        password = webDriver.findElement(passwordLocator);
        password.sendKeys(passwordPopulate);

        logInKey = webDriver.findElement(logKeyLocator);
        logInKey.click();
    }
}
