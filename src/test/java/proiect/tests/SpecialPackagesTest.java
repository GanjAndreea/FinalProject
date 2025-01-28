package proiect.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import proiect.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class SpecialPackagesTest {

    //Facem o metoda de test care merge de pe pagina principala pana pe pagina Pachete Speciale

    public WebDriver driver;     //Acest driver ofera acces pe browser

    @Test
    public void navigateFromHomePageToSpecialPackagesPage() {
        openBrowser();
        HomePage homePage = new HomePage(driver);  //obiect care are acces la toate metodele din Cat Page
        homePage.isPageLoaded();
        homePage.goToDesireMenu("PACHETE SPECIALE");
//        clickOnOffersMenu();
//        clickOnOffersMenu();
//        scrollDown();
//        selectHappyBirthdayPackage();
//        littlescrollDown();
//        selectAnimal();
//        littlescrollDown();
//        fillPersonName();
//        fillAnimalName();
//        selectBowlColor();
//        selectBoxColor();
//        selectSend();
//        addToCart();
//        pause();
//        verifyCart();
//        selectDeliveryMethod("GRATUIT: ridicare din Cugir, strada 21 Decembrie 1989, Nr.58");
//        clickOnCompleteOrder();
//        fillPersonalData();
//        quitBrowser();
    }

    //Facem o metoda care sa deschida browser
    public void openBrowser() {
        driver = new ChromeDriver();   //deschide Chrome
        driver.get("https://www.animarket.ro/");
        driver.manage().window().maximize();
    }

    //Facem o metoda care selecteaza pachet zi de nastere
    public void selectHappyBirthdayPackage() {
        WebElement happyBirthdayElement = driver.findElement(By.xpath("//a[@href='https://www.animarket.ro/cadou-pentru-ziua-blanosului-tau/']"));
        happyBirthdayElement.click();
    }

    //Facem o metoda care selecteaza animalutul
    public void selectAnimal() {
        WebElement animalElement = driver.findElement(By.xpath("//a[@href='https://www.animarket.ro/produs/cadou-pentru-ziua-pisicii/']"));
        animalElement.click();
    }

    //Facem o metoda care completeaza numele persoanei care comanda
    public void fillPersonName() {
        WebElement personNameFieldElement = driver.findElement(By.xpath("//input[@id='vfb-field-36']"));
        personNameFieldElement.sendKeys("Andreea");
    }

    //Facem o metoda care completeaza nume animalut
    public void fillAnimalName() {
        WebElement animalNameFieldElement = driver.findElement(By.xpath("//input[@id='vfb-field-17']"));
        animalNameFieldElement.sendKeys("Pisicuta");
        pause();
    }

    //Facem o metoda care alege culoare bol
    public void selectBowlColor() {
        WebElement bowlColorElement = driver.findElement(By.xpath("//select[@id='vfb-field-39']"));
        bowlColorElement.sendKeys("Verde");
        bowlColorElement.sendKeys(Keys.ENTER);
        bowlColorElement.click();
        pause();
    }

    //Facem o metoda care alege culoare litiera
    public void selectBoxColor() {
        WebElement boxColorTypeElement = driver.findElement(By.xpath("//select[@id='vfb-field-38']"));
        boxColorTypeElement.sendKeys("Gri");
        boxColorTypeElement.sendKeys(Keys.ENTER);
        boxColorTypeElement.click();
        pause();
    }

    //Facem o metoda care apasa pe Trimite
    public void selectSend() {
        WebElement sendButton = driver.findElement(By.id("vfb-field-15"));
        sendButton.click();
        pause();
    }

    //Facem o metoda care adauga in cos pachetul ales
    public void addToCart() {
        WebElement addToCartElement = driver.findElement(By.xpath("//button[@value='2176']"));
        addToCartElement.click();
        pause();
    }

    public void verifyCart() {
        WebElement verifyCartElement = driver.findElement(By.xpath("//a[@href='https://www.animarket.ro/cos/']"));
        verifyCartElement.click();
    }

    //Facem o metoda care sa selecteze metoda de livrare
    public void selectDeliveryMethod(String delivery) {
        WebElement freeDelivery = driver.findElement(By.xpath("//label[@for='shipping_method_0_flat_rate5']"));
        WebElement pickUpDelivery = driver.findElement(By.xpath("//label[@for='shipping_method_0_local_pickup6']"));
        List<WebElement> deliveryMethodList = new ArrayList<>();
        deliveryMethodList.add(freeDelivery);
        deliveryMethodList.add(pickUpDelivery);
        for (int i = 0; i < deliveryMethodList.size(); i++) {                          //se parcurge lista
            if (deliveryMethodList.get(i).getText().equals(delivery)) {           //cand ajunge la elementul cautat ia textul de pe element pentru a gasi ce cautam
                deliveryMethodList.get(i).click();                              //face click pe elemntul dorit
            }
        }
        pause();
    }

    //Facem o metoda care sa faca click pe Finalizare comanda
    public void clickOnCompleteOrder() {
        WebElement completeOrder = driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']"));
        completeOrder.click();
    }
    public void fillPersonalData(){
        selectBillingType("Persoana fizica");
        scrollDown();
        fillFirstName("Andreea");
        fillLastName("Popescu");
        fillStreet("Strada Visinului Nr.18");
        fillLocality("Halchiu");
        selectCounty("Brasov");
        fillPostCode("505100");
        fillPhoneNumber("0751221331");
        fillEmail("andreea_popescu@gmail.com");
        scrollDown();
        selectPayMethod("Ramburs");
        littlescrollDown();
        clickOnAcceptTermsAndConditions();
        clickOnPlaceOrder();
    }
    //Facem o metoda care sa selecteze tipul de facturare
    public void selectBillingType (String billingType){
        WebElement billingTypeElement = driver.findElement(By.xpath("//select[@id='persoana']"));
        billingTypeElement.sendKeys(billingType);
        billingTypeElement.sendKeys(Keys.ENTER);
        billingTypeElement.click();
    }

    //Facem o metoda care sa completeze Prenumele
    public void fillFirstName(String firstName){
        WebElement firstNameFieldElement = driver.findElement(By.xpath("//input[@id='billing_first_name']"));
        firstNameFieldElement.sendKeys(firstName);
    }

    //Facem o metoda care sa completeze Numele
    public void fillLastName (String lastName){
        WebElement lastNameFieldElement = driver.findElement(By.xpath("//input[@id='billing_last_name']"));
        lastNameFieldElement.sendKeys(lastName);
    }

    //Facem o metoda care sa completeze Strada
    public void fillStreet (String street){
        WebElement streetFieldElement = driver.findElement(By.xpath("//input[@id='billing_address_1']"));
        streetFieldElement.sendKeys(street);
    }

    //Facem o metoda care sa completeze localitatea
    public void fillLocality (String locality){
        WebElement localityFieldElement = driver.findElement(By.xpath("//input[@id='billing_city']"));
        localityFieldElement.sendKeys(locality);
    }

    //Facem o metoda care sa selecteze Judetul
    public void selectCounty (String county){
        WebElement countyTypeElement = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']"));
        countyTypeElement.sendKeys(county);
        countyTypeElement.sendKeys(Keys.ENTER);
    }

    //Facem o metoda care sa completeze Codul postal
    public void fillPostCode (String postCode){
        WebElement postCodeFieldElement = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
        postCodeFieldElement.sendKeys(postCode);
    }

    //Facem o metoda care sa completeze numarul de telefon
    public void fillPhoneNumber (String phoneNumber){
        WebElement phoneNumberFieldElement = driver.findElement(By.xpath("//input[@id='billing_phone']"));
        phoneNumberFieldElement.sendKeys(phoneNumber);
    }

    //Facem o metoda care sa completeze adresa de email
    public void fillEmail (String email){
        WebElement emailFieldElement = driver.findElement(By.xpath("//input[@id='billing_email']"));
        emailFieldElement.sendKeys(email);
    }

    //Facem o metoda care sa selecteze modalitatea de plata
    public void selectPayMethod(String pay){
        WebElement refundPay = driver.findElement(By.xpath("//div[@class='payment_box payment_method_cod']"));
        WebElement mobilPay = driver.findElement(By.xpath("//label[@for='payment_method_sn_wc_mobilpay']"));
        List<WebElement> payMethodList = new ArrayList<>();                     //facem o lista goala
        payMethodList.add(refundPay);                                       //se adauga elemente in lista
        payMethodList.add(mobilPay);
        for(int i=0; i<payMethodList.size();i++){                          //se parcurge lista
            if(payMethodList.get(i).getText().equals(pay)){           //cand ajunge la elementul cautat ia textul de pe element pentru a gasi ce cautam
                payMethodList.get(i).click();                              //face click pe elemntul dorit
            }
        }
        pause();
    }

    //Facem o metoda care sa selecteze "am citit termenii si conditiile"
    public void clickOnAcceptTermsAndConditions(){
        WebElement acceptButton = driver.findElement(By.xpath("//input[@id='terms']"));
        acceptButton.click();
    }

    //Facem o metoda care sa faca click pe Plaseaza comanda
    public void clickOnPlaceOrder(){
        WebElement placeOrderButton = driver.findElement(By.id("place_order"));
        placeOrderButton.click();
    }

    //Facem o metoda care sa inchida Browser
    public void quitBrowser(){
        driver.quit();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }

    public void littlescrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
    }

    public void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
