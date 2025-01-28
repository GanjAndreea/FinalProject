package proiect.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import proiect.pages.CatCommonPage;
import proiect.pages.DogCommonPage;
import proiect.pages.HomePage;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public CatCommonPage catCommonPage;
    public DogCommonPage dogCommonPage;

    @BeforeMethod
    public void openBroswer(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);  //obiect care are acces la toate metodele din Home Page
        catCommonPage = new CatCommonPage(driver);
        dogCommonPage = new DogCommonPage(driver);

        driver.get("https://www.animarket.ro/");
        //Facem fereastra la dimensiunea maxima
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitBroswer(){
        if(driver != null){
            driver.quit();
        }
    }
}
