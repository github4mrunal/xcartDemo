package homepage;

import basetest.BaseTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TopMenuTest extends BaseTest {
    @Before
    public void openBrowser(){
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);

  }

    @Test
  public void verifyUserShouldNavigateToShippingPageSuccessfully() {

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[3]/a"));
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User is not on Shipping page", expectedMessage, actualMessage);

    }


@Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {

       clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[4]/a/span"));
       // clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/ul[1]/li[2]/a[1]/span[1]"));
        String expectedText = "New arrivals";
        String actualText = getTextFromElement(By.xpath("//h1[text()='New arrivals']"));
        Assert.assertEquals("User is not on New Arrivals",expectedText,actualText);

    }
@Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a"));
        String expectedText = "Coming soon";
    String actualText = getTextFromElement(By.xpath("//h1[text()='Coming soon']"));
        Assert.assertEquals("User is not on Coming soon page",expectedText,actualText);


    }
@Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a"));
    //  clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/a[1]/span[1]"));
     // clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/ul[1]/li[4]/a[1]/span[1]"));
      String expectedText = "Contact us";
      String actualText = getTextFromElement(By.id("page-title"));
      Assert.assertEquals("User is not on Contact us page",expectedText,actualText);


    }
@After
    public void tearDown() {
        closeBrowser();



    }
}
