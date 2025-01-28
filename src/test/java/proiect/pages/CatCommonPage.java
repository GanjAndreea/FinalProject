package proiect.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CatCommonPage extends BasePage {

    //Webelemente specifice paginii
    @FindBy(xpath = "//h1")
    WebElement pageTitleElement;

    @FindBy(xpath = "//h2[@class='woocommerce-loop-category__title']")
    private List <WebElement> submenuListElement;

    public CatCommonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        pause();
        Assert.assertEquals(pageTitleElement.getText(), "PISICI", "Title is invalid and actual value is" + pageTitleElement.getText());
    }

    //Facem o metoda care sa faca click pe submeniul ales de noi
   public void selectSubMenu(String subMenuName){
        elementsHelper.selectSubMenu(subMenuName,submenuListElement);
        pause();
   }

    public void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
