package proiect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{

    //Identificam webelementele specifice paginii
    @FindBy(xpath = "//li")
    private List<WebElement> menuListElements;

    @FindBy(id = "image-12-9")
    private WebElement pageTitle;

    //Constructor care preia constructorul din clasa mostenita BasePage
    public HomePage(WebDriver driver) {

        super(driver);
    }

    //Iplementare proprie pentru Home Page a metodei abstracte din Base Page
    @Override
    public void isPageLoaded() {
        Assert.assertTrue(pageTitle.getAttribute("class").equals("ct-image"),"Page is not loaded correctly.");
    }

    //Facem metode specifice pentru pagina

    //Facem o metoda care sa faca click pe meniul ales de noi
    public void goToDesireMenu(String menuName){
        elementsHelper.selectElementbyTextFromList(menuName,menuListElements);
    }


}
