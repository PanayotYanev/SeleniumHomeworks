package SeleniumFive.TablePress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePress {
    WebElement tableRows;
    List<WebElement> secondRowInTableRows;
    List<WebElement> firstRowInTableRows;
    List<WebElement> zipCodeRowInTableRows;

    public TablePress(WebDriver webDriver) {
        webDriver.get("https://tablepress.org/demo");
        this.tableRows = webDriver.findElement(new By.ByClassName("row-hover"));
        this.firstRowInTableRows = tableRows.findElements(new By.ByClassName("column-1"));
        this.secondRowInTableRows = tableRows.findElements(new By.ByClassName("column-2"));
        this.zipCodeRowInTableRows = tableRows.findElements(new By.ByClassName("column-3"));
    }

    public void printOnWhichTablePageWeAre(WebDriver webDriver){
        WebElement showingElementsThatAreShown = webDriver.findElement(new By.ById("tablepress-demo_info"));
        System.out.println(showingElementsThatAreShown.getText());
    }

    public void printTheContentOfTheTable(WebDriver webDriver){
        System.out.println(tableRows.getText());
    }

    public void printLastNames(){
        for(WebElement info : secondRowInTableRows){
            System.out.println(info.getText());
        }
    }

    public void printZipCode(){
        for(int i = 0; i < firstRowInTableRows.size(); i++){
            if(firstRowInTableRows.get(i).getText().equals("Rachel") && secondRowInTableRows.get(i).getText().equals("English")){
                System.out.println(zipCodeRowInTableRows.get(i).getText());
                break;
            }
        }
    }

    public void printPoints(){
        List<WebElement> pointsRowInTableRows = tableRows.findElements(new By.ByClassName("column-5"));
        for(WebElement point : pointsRowInTableRows){
            System.out.println(point.getText());
        }
    }
}
