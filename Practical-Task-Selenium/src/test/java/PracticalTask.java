import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class PracticalTask {
    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void setUpMethod() {

    }

    @Test
    public void testOne() {
        //Този тест съм го оставил, за да пиша кода за следващите подточки.

        WebElement tabletToBeEdited = webDriver.findElement(new By.ByXPath(".//a[contains(text(), 'TabletOfGold')]"));
        tabletToBeEdited.click();

        WebElement attributes = webDriver.findElement(new By.ByClassName("cus-tag-green"));
        attributes.click();

        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(new By.ByXPath(".//a[contains(text(), ' Set attributes values')]")))).click();
        WebElement modalForm = webDriver.switchTo().activeElement();

        //На 51 ред ми дава грешка, че не може да открие елемента или той изобщо не съществува
        List<WebElement> radioButtons = modalForm.findElement(new By.ById("pageContent")).findElements(new By.ByClassName("radio"));
        radioButtons.get(radioButtons.size() - 1).findElement(new By.ByXPath(".//input[value = '89']"));
    }

    @Test
    public void testPracticePage() {
        HomePage homePage = new HomePage(webDriver, wait);
        homePage.getLoginPage()
                .logIn("admin", "password")
                .clickOnCategoriesAndProducts()
                .createNewProduct("TabletOfGold");
    }
}
