package shopping;

import basetest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingTestTrial extends BaseTest {
    @Before
    public void setUp(){
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }
    @Test
    public  void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        hoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        // mouseHoverToElement(By.xpath("//span[text()='Hot deals']/parent::li/ancestor::ul/descendant::ul"));  //mouse hover to 'hot deals'
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        // clickOnElement(By.xpath("//a[text()='Sale']/parent::li"));  //click on sales
        String saleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleText, actualSalesText);
        hoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a")); //click on 'A to Z'
        Thread.sleep(2000);
        //  mouseHoverToElement(By.xpath("//a[text()='BACtrack Vio - Bluetooth App Enabled Breathalyzer']")); //hover to product BACtrack
        //mouseHoverToElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));  //mouse hover to Avengers
        clickOnElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));
        clickOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div[3]/ul/li[2]/label/div/input[2]")); //check box of product
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/form[2]/div[2]/div[1]/div[3]/button[1]"));
        //   clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-16']"));//click on add to cart
        Thread.sleep(3000);
        String expectedCartText = "Product has been added to your cart";   //assert for add to cart
        String actualCartText = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product Has Not Been Added To The Cart",expectedCartText,actualCartText);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on your cart
        clickOnElement(By.xpath("//a[@class='regular-button cart']")); //click on view cart
        String shopCarttext = "Your shopping cart - 1 item";
        String realShopCart = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User's Items Have Not Been Added To Cart",shopCarttext,realShopCart);
        driver.findElement(By.id("amount16")).clear();//clear qauntity '1'
        driver.findElement(By.id("amount16")).click(); //click on quantity field
        driver.findElement(By.id("amount16")).sendKeys("2");
        //sendTextToElement(By.id("amount35"),"2");//add quantity '2'
        String shoppingCartText = "Your shopping cart - 2 items";    //verify 2 items in cart
        String shoppingcartReal = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Cart Does nOt Have 2 Items",shoppingCartText,shoppingcartReal);
        // Thread.sleep(1000);
        String subTotalText = "Subtotal: $59.98";                 //verify subtotal
        String subTotalTextReal = getTextFromElement(By.xpath("//span[@class='cart-subtotal']/parent::li/ancestor::ul"));
        Assert.assertEquals("SubTotal Is Wrong",subTotalText,subTotalTextReal);
        String totalText ="$66.53";                     //verify Total
        String totalTextActual = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Is Incorrect",totalText,totalTextActual);
        clickOnElement(By.xpath("//span[text()='Go to checkout']")); //click on check out.
        String logText = "Log in to your account";                   //verify login account page
        String logTextReal = getTextFromElement(By.xpath("//h3[text()='Log in to your account']"));
        Assert.assertEquals("User Is Not On Login your Account Page",logText,logTextReal);
        sendTextToElement(By.id("email"),"primetime131@gmail.com");  //enter email id
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));  //click on continue
        String secureText = "Secure Checkout";                            //verify secure checkout text
        String secureTextReal = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("User Is Not On secureCheckout page",secureText,secureTextReal);
        sendTextToElement(By.id("shippingaddress-firstname"),"Sheldon");  //firstname
        sendTextToElement(By.id("shippingaddress-lastname"),"Cooper");  //lastname
        sendTextToElement(By.id("shippingaddress-street"),"42,Wallby street"); //address
        selectByValueFromDropDown(By.id("shippingaddress-country-code"),"US"); //country
        clickOnElement(By.id("create_profile"));                  //tick on checkbox
        sendTextToElement(By.id("password"),"sheldonisgreat"); //password
        clickOnElement(By.id("method128"));             //local shipping delievery method
        Thread.sleep(1000);
        clickOnElement(By.id("pmethod6"));               //payment method COD
        String expectedTotal = "$66.53";                  //verify total
        String actualTotal = getTextFromElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("TotalIs Wrong",expectedTotal,actualTotal);
        Thread.sleep(2000);
        //   mouseHoverToElement(By.xpath("//span[contains(text(),'Place order: $64.48')]")); //mousehover to order button
        //   Actions actions = new Actions(driver);

        //  Thread.sleep(1000);
        //   clickOnElement(By.xpath("//*[@id=\"form-1622558108622\"]/div[4]/button/span"));
        //  clickOnElement(By.xpath("//span[text()='Place order: $64.48']/parent::button")); //click on place order button
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
 /*   String thankyouText = "Thank you for your order";    //verifying thank you page
    String thankyouTextReal = getTextFromElement(By.xpath("//h1[text()='Thank you for your order']"));
    Assert.assertEquals("Order Has Not Been Placed ",thankyouText,thankyouTextReal);*/
    }


}
