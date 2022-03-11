package pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final String HOME_PAGE_URL = "https://demo.vamshop.com/";
    WebDriver webDriver;
    WebDriverWait wait;
    WebElement adminClick;
    WebElement click;

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;

        inItPage();

        adminClick = webDriver.findElement(new By.ByClassName("page"));
        click = adminClick.findElement(new By.ByTagName("a"));
        locateAndClickTheLoginButton();
    }

    public void locateAndClickTheLoginButton(){
        click.click();
    }

    private void inItPage(){
        this.webDriver.get(HOME_PAGE_URL);
    }

    public LogInPage getLoginPage(){
        return new LogInPage(webDriver, wait);
    }
}
