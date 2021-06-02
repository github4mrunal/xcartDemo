package hotdeals;

import basetest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends BaseTest {
    @Before
    public void openUrl() {
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a"));
        //clickOnElement(By.xpath("//a[@data-sort-by='translations.name']/parent::li/ancestor::ul"));
        String expectedVisibleText = "Name A - Z";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[3]/a"));
        String expectedVisibleText = "Price Low - High";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text()='Price Low - High']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);

    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[7]/a"));
        String expectedVisibleText = "Rates";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text()= 'Rates ']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);


    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[6]/a"));
        String expectedVisibleText = "Name Z - A";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text() = 'Name Z - A']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);


    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@class ='title']"));
        Assert.assertEquals("User is not on sale page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[4]/a"));
        String expectedVisibleText = "Price High - Low";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text() = 'Price High - Low']"));
        Assert.assertEquals("Products not arranged alphabetically", expectedVisibleText, actualVisibleText);


    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() {
        hoverToElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse" +
                " ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) > " +
                "span.primary-title:nth-child(1)"));
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));
        String expectedText = "Bestsellers";
        String actualText = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User is not on Bestsellers page", expectedText, actualText);
        hoverToElement(By.xpath("//span[@class ='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[6]/a"));
        String expectedVisibleText = "Rates";
        String actualVisibleText = getTextFromElement(By.xpath("//span[text() = 'Rates ']"));
        Assert.assertEquals("Products not sort by Rates", expectedVisibleText, actualVisibleText);


    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
