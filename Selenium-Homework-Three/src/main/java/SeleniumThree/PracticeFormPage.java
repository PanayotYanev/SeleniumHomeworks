package SeleniumThree;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage {
    public void fillCredentialsOfStudent(WebDriver webDriver){
        //firstName
        WebElement firstName = webDriver.findElement(new By.ById("firstName"));
        firstName.sendKeys("Panayot");

        //lastName
        WebElement lastName = webDriver.findElement(new By.ById("lastName"));
        lastName.sendKeys("Yanev");

        //userEmail
        WebElement email = webDriver.findElement(new By.ById("userEmail"));
        email.sendKeys("test@email.net");

        //Gender - gender-radio-1
        WebElement gender = webDriver.findElement(new By.ById("gender-radio-1"));
        ((JavascriptExecutor)webDriver).executeScript("argument[0].click()", gender);

        //userNumber
        WebElement userNumber = webDriver.findElement(new By.ById("userEmail"));
        userNumber.sendKeys("1234567890");

        //dateOfBirthInput
        WebElement dateOfBirth = webDriver.findElement(new By.ById("dateOfBirthInput"));
        dateOfBirth.sendKeys("06/18/2000");
        dateOfBirth.sendKeys(Keys.ENTER);

        //Hobbies
        WebElement hobbyReading = webDriver.findElement(new By.ById("hobbies-checkbox-2"));
        ((JavascriptExecutor)webDriver).executeScript("argument[0].click()", hobbyReading);

        WebElement hobbyMusic = webDriver.findElement(new By.ById("hobbies-checkbox-3"));
        ((JavascriptExecutor)webDriver).executeScript("argument[0].click()", hobbyMusic);

        //Address - currentAddress
        WebElement currentAddress = webDriver.findElement(new By.ById("currentAddress"));
        currentAddress.sendKeys("Burgas Burgas Burgas Burgas");

        //State
        Select state = new Select(webDriver.findElement(By.id("state")));
        state.selectByVisibleText("NCR");
        state.selectByIndex(1);

        //City
        Select city = new Select(webDriver.findElement(By.id("city")));
        city.selectByVisibleText("Delhi");
        city.selectByIndex(1);

        //Submit
        WebElement submit = webDriver.findElement(new By.ById("submit"));
        ((JavascriptExecutor)webDriver).executeScript("argument[0].click()", submit);
    }
}
