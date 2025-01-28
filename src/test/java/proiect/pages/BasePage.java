package proiect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import proiect.helpers.ElementsHelper;

public abstract class BasePage {

    //variabila driver va fi folosita in toate paginile care o sa mosteneasca Base Page
    public WebDriver driver;

    public ElementsHelper elementsHelper;

    //Facem un constructor care initializeaza driverul
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsHelper = new ElementsHelper(driver);  //initializare elementsHelper
        PageFactory.initElements(driver,this);
    }

    //Metoda abstracta pe care fiecare pagina trebuie sa o implementeze pentru a verifica daca pagina e incarcata corect
    abstract void isPageLoaded();

}
