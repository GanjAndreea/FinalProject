package proiect.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import proiect.pages.CatCommonPage;
import proiect.pages.CatToysPage;
import proiect.pages.HomePage;

import static proiect.constants.MenuKeys.CAT_MENU;
import static proiect.constants.SubMenuKeys.CAT_SUBMENU;

public class CatTest extends BaseTest{

    //Facem o metoda de test care merge de pe pagina principala pana pe pagina Jucarii pisici

    @Test
    public void navigateFromHomePageToCatToys(){
        homePage.isPageLoaded();
        homePage.goToDesireMenu(CAT_MENU);
        catCommonPage.isPageLoaded();
        catCommonPage.selectSubMenu(CAT_SUBMENU);
        CatToysPage catToysPage = new CatToysPage(driver);
        catToysPage.isPageLoaded();
        catToysPage.fillPersonalData();
    }

}
