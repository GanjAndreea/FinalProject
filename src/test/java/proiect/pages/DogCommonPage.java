package proiect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DogCommonPage extends BasePage {

    //Webelemente specifice paginii
    @FindBy(xpath = "//h1")
    WebElement pageTitleElement;

    @FindBy(xpath = "//h2[@class='woocommerce-loop-category__title']")
    List<WebElement> submenuListElement;

    public DogCommonPage(WebDriver driver) {

        super(driver);
    }

    @Override
    public void isPageLoaded() {
        pause();
        Assert.assertEquals(pageTitleElement.getText(), "CÂINI", "Title is invalid and actual value is" + pageTitleElement.getText());
    }

    //Facem o metoda care sa faca click pe submeniul ales de noi
    public void selectSubMenu(String subMenuName) {
        elementsHelper.selectSubMenu(subMenuName, submenuListElement);
    }

    public void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
