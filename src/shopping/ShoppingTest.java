package shopping;

import basetest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest extends BaseTest {
    @Before
    public void setUp() {
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {

        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));//hoover on sort by label
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a"));//click on A-Z
        Thread.sleep(3000);
        hoverToElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));  //mouse hover to Avengers
        // hoverToElement(By.xpath("//a[text() = 'Avengers: Fabrikations Plush [Related Products']"));//click on product
        //clickOnElement(By.xpath("//input[@data-attribute-id = '65']"));//click on product
        clickOnElement(By.xpath("//button[@class = 'btn  regular-button add-to-cart product-add2cart productid-16']"));//click on add to cart


//        hoverToElement(By.xpath("//a[text() = 'BACtrack Vio - Bluetooth App Enabled Breathalyzer']"));//hoover on product
//        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-35']"));//click on add to cart
        Thread.sleep(3000);


        String expectedMessage = "Product has been added to your cart";
        String actualMessage = getTextFromElement(By.xpath("//li[text() = 'Product has been added to your cart'] "));
        Assert.assertEquals("Product not added to cart", expectedMessage, actualMessage);
        clickOnElement(By.xpath("//a[@class = 'close']"));
        clickOnElement(By.xpath("//div[@class = 'lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on cart
        clickOnElement(By.xpath("//a[@class = 'regular-button cart']"));//view cart
        String expectedShoppingText = "Your shopping cart - 1 item";
        String actualShoppingText = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Your shopping cart is empty", expectedShoppingText, actualShoppingText);
        driver.findElement(By.id("amount16")).clear();//amount clear
        sendTextToElement(By.id("amount16"), "2");
        String expectedVisibleText = "Your shopping cart - 2 items";
        String actualVisibleText = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Your shopping cart is empty", expectedVisibleText, actualVisibleText);
        String expectedSubtotal = "Subtotal: $29.98";
        String actualSubtotal = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]"));
        Assert.assertEquals("Your subtotal amount is wrong", expectedSubtotal, actualSubtotal);
        String expectedTotalAmount = "$36.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//*[@id=\"cart-right\"]/ul/li[4]/span/span"));
        Assert.assertEquals("Your total amount is wrong", expectedTotalAmount, actualTotalAmount);
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[5]/button[1]"));
        String expectedLoginText = "Log in to your account";
        String actualLoginText = getTextFromElement(By.xpath("//h3[text() = 'Log in to your account']"));
        Assert.assertEquals("User can't log in to their account", expectedLoginText, actualLoginText);
        sendTextToElement(By.id("email"), "maggie33@gmail.com");//enter email
        clickOnElement(By.xpath("//button[@class = 'btn  regular-button anonymous-continue-button submit']"));//click on continue button
        String secureCheckoutExpectedText = "Secure Checkout";//verify secure checkout
        String secureCheckOutActualText = getTextFromElement(By.xpath("//h1[@class = 'title']"));
        Assert.assertEquals("User is not on Secure checkout page", secureCheckoutExpectedText, secureCheckOutActualText);
        sendTextToElement(By.id("shippingaddress-firstname"), "Maggie");//Firstname
        sendTextToElement(By.id("shippingaddress-lastname"), "McPie");//Last name
        sendTextToElement(By.id("shippingaddress-street"), "123 Watling Street");//Address
        driver.findElement(By.id("shippingaddress-city")).clear();
        sendTextToElement(By.id("shippingaddress-city"), "Los Angeles");
        // selectByValueFromDropDown(By.id("shippingaddress-state-id"),"California");
        //   sendTextToElement(By.id("shippingAddress[zipcode]"),"90001");
        selectByValueFromDropDown(By.id("shippingaddress-country-code"), "US");//Country
        //  sendTextToElement(By.id("shippingaddress-custom-state"),"California");
        clickOnElement(By.id("create_profile"));//Create id check box
        sendTextToElement(By.id("password"), "Test123");//password
        hoverToElement(By.id("method128"));
        clickOnElement(By.id("method128"));             //local shipping delievery method
        Thread.sleep(1000);
        //   clickOnElement(By.id("pmethod6"));
        //  driver.findElement(By.xpath("//*[@id=\"method128\"]")).sendKeys(Keys.RETURN);
        clickOnElement(By.xpath("//*[@id=\"pmethod6\"]"));
        Thread.sleep(3000);
        // driver.findElement(By.id("method128")).sendKeys(Keys.ENTER);            //local shipping delivery method
        //driver.findElement(By.id("pmethod6")).sendKeys(Keys.ENTER);//payment method

        //clickOnElement(By.cssSelector("#method128"));
        //local shipping delivery

        // clickOnElement(By.cssSelector("#pmethod6"));            //payment method
        // driver.findElement(By.xpath("//span[text() = 'Local shipping']")).click();//shipping
        //driver.findElement(By.xpath("//span[text() = 'COD']")).click();//payment method

        String expectedFinalTotalAmount = "$33.95";
        String actualFinalTotalAmount = getTextFromElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("Total amount is wrongly displayed", expectedFinalTotalAmount, actualFinalTotalAmount);
        hoverToElement(By.xpath("//span[text()='Place order: $33.95']/parent::button"));
        clickOnElement(By.xpath("//span[text()='Place order: $33.95']/parent::button")); //click on place order button
        String expectedFinalMessage = "Thank you for your order";
        String actualFinalMessage = getTextFromElement(By.xpath("//h1[text()='Thank you for your order']"));
        Assert.assertEquals("Final amount not matching", expectedFinalMessage, actualFinalMessage);


    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() {


        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        String expectedText = "Bestsellers";
        String actualText = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User is not on Bestsellers page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id= 'XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1']/li[4]/a"));
        //clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a"));
        //clickOnElement(By.xpath("//a[@data-sort-by='translations.name']/parent::li/ancestor::ul"));
        String expectedVisibleText = "Name A - Z";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);
        hoverToElement(By.xpath("//a[text() = 'Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/div/div[3]/ul/li[7]/div/div[2]/div[4]/div/button/span"));
        String expectedMessage = "Product has been added to your cart";
        String actualMessage = getTextFromElement(By.xpath("//li[text() = 'Product has been added to your cart'] "));
        Assert.assertEquals("Product not added to cart", expectedMessage, actualMessage);
        clickOnElement(By.xpath("//a[@class = 'close']"));
        clickOnElement(By.xpath("//div[@class = 'lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on cart
        clickOnElement(By.xpath("//a[@class = 'regular-button cart']"));//view cart
        String expectedShoppingText = "Your shopping cart - 1 item";
        String actualShoppingText = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Your shopping cart is empty", expectedShoppingText, actualShoppingText);
        clickOnElement(By.xpath("//a[@class = 'clear-bag']"));
        String emptyCartText = "Are you sure you want to clear your cart?";
        String emptyCartTextActual = driver.switchTo().alert().getText();  //to get text from element that cant be inspected with right click.
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartText, emptyCartTextActual);
        driver.switchTo().alert().accept();               //to click'ok' on alert window when no right click available to inspect
        String empty1CartText = "Item(s) deleted from your cart";            //verifying empty cart green bar
        String emptyCartTextActualIs = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empty1CartText, emptyCartTextActualIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your cart is empty message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);
    }
    public void tearDown(){
        closeBrowser();
    }


}

