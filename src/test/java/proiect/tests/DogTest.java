package proiect.tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import proiect.pages.DogAntiparasiticPage;
import proiect.pages.DogCommonPage;
import proiect.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

import static proiect.constants.MenuKeys.DOG_MENU;
import static proiect.constants.SubMenuKeys.DOG_SUBMENU;

public class DogTest extends BaseTest{

    //Facem o metoda de test care merge de pe pagina principala pana pe pagina Suplimente Caini

    @Test
    public void navigateFromHomePageToDogAntiparasitic() {
        homePage.isPageLoaded();
        homePage.goToDesireMenu(DOG_MENU);
        dogCommonPage.isPageLoaded();
        dogCommonPage.selectSubMenu(DOG_SUBMENU);
        DogAntiparasiticPage dogAntiparasiticPage = new DogAntiparasiticPage(driver);
        dogAntiparasiticPage.isPageLoaded();
        dogAntiparasiticPage.fillPersonalData();
    }

}
