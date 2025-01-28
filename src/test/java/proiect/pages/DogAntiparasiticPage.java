package proiect.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DogAntiparasiticPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement pageTitleElement;

    @FindBy(xpath = "//a[@href='?add-to-cart=3224']")
    WebElement addToCartElement;

    @FindBy(xpath = "//a[@href='https://www.animarket.ro/cos/']")
    WebElement verifyCartElement;

    @FindBy(xpath = "//label[@for='shipping_method_0_flat_rate5']")
    WebElement courierDelivery;
    @FindBy(xpath = "//label[@for='shipping_method_0_local_pickup6']")
    WebElement pickUpDelivery;

    @FindBy(xpath = "//a[@href='https://www.animarket.ro/finalizare/']")
    WebElement completeOrderElement;

    @FindBy(id = "persoana")
    WebElement billingTypeElement;

    @FindBy(id = "billing_first_name")
    WebElement firstNameFieldElement;

    @FindBy(id = "billing_last_name")
    WebElement lastNameFieldElement;

    @FindBy(id = "billing_address_1")
    WebElement streetFieldElement;

    @FindBy(id = "billing_city")
    WebElement cityFieldElement;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    WebElement countyTypeElement;

    @FindBy(id = "billing_postcode")
    WebElement postCodeFieldElement;

    @FindBy(id = "billing_phone")
    WebElement phoneNumberFieldElement;

    @FindBy(id = "billing_email")
    WebElement emailFieldElement;

    @FindBy(xpath = "//label[@for='payment_method_cod']")
    WebElement refundPay;
    @FindBy(xpath = "//label[@for='payment_method_sn_wc_mobilpay']")
    WebElement mobilPay;

    @FindBy(xpath = "//input[@id='terms']")
    WebElement acceptButton;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public DogAntiparasiticPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Antiparazitare", " Title is invalid and actual value is : " + pageTitleElement.getText());
    }

    public void fillPersonalData() {
        addToCart();
        pause();
        verifyCart();
        selectDeliveryMethod("Livrare gratuită la comenzi mai mari de 150 RON");
        clickOnCompleteOrder();
        selectBillingType();
        fillFirstName();
        fillLastName();
        fillStreet();
        fillCity();
        selectCounty();
        fillPostCode();
        fillPhoneNumber();
        fillEmail();
        elementsHelper.scrollDown();
        selectPayMethod("Plătește cu numerar la livrare.");
        clickOnAcceptTermsAndConditions();
        clickOnPlaceOrder();
    }

    //Facem o metoda care sa faca click pe aduga in cos
    public void addToCart() {
        elementsHelper.scrollDown();
        elementsHelper.clickElement(addToCartElement);
        pause();
    }

    //Facem o metoda care verifica daca produsele sunt adaugate in cos
    public void verifyCart() {
        elementsHelper.clickElement(verifyCartElement);
        elementsHelper.scrollDown();
    }

    //Facem o metoda care sa selecteze metoda de livrare
    public void selectDeliveryMethod(String delivery) {
        List<WebElement> deliveryMethodList = new ArrayList<>();                     //facem o lista goala
        deliveryMethodList.add(courierDelivery);
        deliveryMethodList.add(pickUpDelivery);
        elementsHelper.selectElementbyTextFromList(delivery,deliveryMethodList);
    }

    //Facem o metoda care sa faca click pe Finalizare comanda
    public void clickOnCompleteOrder() {
        elementsHelper.clickElement(completeOrderElement);
    }

    //Facem o metoda care sa selecteze tipul de facturare
    public void selectBillingType() {
        elementsHelper.selectElementUsingKeys(billingTypeElement,"Persoana fizica",Keys.ENTER);
    }

    //Facem o metoda care sa completeze Prenumele
    public void fillFirstName() {
        elementsHelper.fillElement(firstNameFieldElement,"Andreea");
    }

    //Facem o metoda care sa completeze Numele
    public void fillLastName() {
        elementsHelper.fillElement(lastNameFieldElement,"Popescu");
    }

    //Facem o metoda care sa completeze Strada
    public void fillStreet() {
        elementsHelper.fillElement(streetFieldElement,"Strada Visinului Nr.18");
    }

    //Facem o metoda care sa completeze localitatea
    public void fillCity() {
        elementsHelper.fillElement(cityFieldElement,"Halchiu");
    }

    //Facem o metoda care sa selecteze Judetul
    public void selectCounty() {
        elementsHelper.selectElementUsingKeys(countyTypeElement,"Brasov",Keys.ENTER);
    }

    //Facem o metoda care sa completeze Codul postal
    public void fillPostCode() {
        elementsHelper.fillElement(postCodeFieldElement,"505100");
    }

    //Facem o metoda care sa completeze numarul de telefon
    public void fillPhoneNumber() {
        elementsHelper.fillElement(phoneNumberFieldElement,"0751221331");
    }

    //Facem o metoda care sa completeze adresa de email
    public void fillEmail() {
        elementsHelper.fillElement(emailFieldElement,"andreea_popescu@gmail.com");
    }

    //Facem o metoda care sa selecteze modalitatea de plata
    public void selectPayMethod(String pay) {
        elementsHelper.scrollDown();
        List<WebElement> payMethodList = new ArrayList<>();                     //facem o lista goala
        payMethodList.add(refundPay);                                       //se adauga elemente in lista
        payMethodList.add(mobilPay);
        elementsHelper.selectElementbyTextFromList(pay,payMethodList);
        pause();
    }

    //Facem o metoda care sa selecteze "am citit termenii si conditiile"
    public void clickOnAcceptTermsAndConditions() {
        elementsHelper.clickElement(acceptButton);
    }

    //Facem o metoda care sa faca click pe Plaseaza comanda
    public void clickOnPlaceOrder() {
        elementsHelper.clickElement(placeOrderButton);
    }

    public void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
