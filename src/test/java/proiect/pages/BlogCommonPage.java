package proiect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BlogCommonPage extends BasePage{

    @FindBy(className = "ct-span")
    WebElement pageTitleElement;

    @FindBy(css = ".ct-span")
    List<WebElement> submenuListElement;

    public BlogCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        pause();
        Assert.assertEquals(pageTitleElement.getText(), "Panleucopenia Felină: O Boală Mortală pentru Pisici", "Title is invalid and actual value is" + pageTitleElement.getText());
    }

    //Facem o metoda care sa faca click pe submeniul ales de noi
    public void selectSubMenu(String subMenuName) {
        pause();
        elementsHelper.selectElementbyTextFromList(subMenuName,submenuListElement);
    }

    public void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
