package proiect.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import proiect.pages.BlogCommonPage;
import proiect.pages.HomePage;

import static proiect.constants.MenuKeys.BLOG_MENU;
import static proiect.constants.SubMenuKeys.BLOG_SUBMENU;

public class BlogTest extends BaseTest{

    //Facem o metoda de test care merge de pe pagina principala pana pe pagina Blog

    @Test
    public void navigateFromHomePageToBlogPage() {
        HomePage homePage = new HomePage(driver);  //obiect care are acces la toate metodele din Cat Page
        homePage.isPageLoaded();
        homePage.goToDesireMenu(BLOG_MENU);
        BlogCommonPage blogCommonPage = new BlogCommonPage(driver);
        blogCommonPage.isPageLoaded();
        blogCommonPage.selectSubMenu(BLOG_SUBMENU);
        interactWithSubmenu();
    }

    //Facem o metoda care sa interactioneze cu pagina Cum sa alegi un animal de companie
    public void interactWithSubmenu (){
        System.out.println("Textul afisat este: " + driver.findElement(By.xpath("//span[@id='span-7-4488']")).getText());
    }
}
