package proiect.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementsHelper {

    WebDriver driver;

    JavascriptExecutor js;

    public ElementsHelper(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,400)");
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public void selectElementbyTextFromList(String elementName, List<WebElement> elementsList){
        for(WebElement element : elementsList){   //parcurge menuListElements pe fiecare element
            if (element.getText().equals(elementName)){   // daca textul de pe element e cel dorit se va face click
                element.click();
                break;
            }
        }
    }

    public void selectSubMenu(String subMenuName, List<WebElement> elementList) {
        for (WebElement element : elementList) {   //parcurge submenuListElements pe fiecare element
            if (element.getText().contains(subMenuName)) {// daca textul de pe element e cel dorit se va face click
                element.click();
                break;
            }
        }
    }

    public void selectElementUsingKeys (WebElement element, String value, Keys key){
        fillElement(element,value);
        element.sendKeys(key);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
