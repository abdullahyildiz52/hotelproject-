package tests.mehmet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import pages.US_0001_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_0001_TC_0002 extends TestBaseRapor {
    QAConcortPage qaConcortPage = new QAConcortPage();
    US_0001_QAConcortPage us0001QAConcortPage = new US_0001_QAConcortPage();
    ReusableMethods reusableMethods=new ReusableMethods();

    @Test
    public void displayed() throws InterruptedException {

        //Anasayfa'da navbarın görülebilmesi ve öğelerin tıklanabilmesi
        extentTest = extentReports.createTest("Siteye geçerli URL ile giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        Thread.sleep(3000);
         Assert.assertTrue(us0001QAConcortPage.tumNavbar.isDisplayed(),"navbar görünür degil");
        extentTest=extentReports.createTest("navbar görünür testi");
        Assert.assertTrue(us0001QAConcortPage.homeButonu.isDisplayed(),"Home butonu görünür degil");
        extentTest=extentReports.createTest("Home Butonu görünür testi");
        Assert.assertTrue(us0001QAConcortPage.roomsButonu.isDisplayed(),"Rooms butonu görünür degil");
        extentTest=extentReports.createTest("Rooms Butonu görünür testi.");
        Assert.assertTrue(us0001QAConcortPage.restaurantButonu.isDisplayed(),"Restaurant butonu görünür değil");
        extentTest=extentReports.createTest("Restauran Butonu görünür testi");
        Assert.assertTrue(us0001QAConcortPage.aboutButonu.isDisplayed(),"About butonu görünür degil");
        extentTest=extentReports.createTest("About Butonu görünür testi");
        Assert.assertTrue(us0001QAConcortPage.blogButonu.isDisplayed(),"Blog butonu görünür değil.");
        extentTest=extentReports.createTest("Blog Butonu görünür testi");
        Assert.assertTrue(us0001QAConcortPage.contactButonu.isDisplayed(),"Contact butonu görünür değil");
        extentTest=extentReports.createTest("Contact Butonu görünür testi");
        Assert.assertTrue(us0001QAConcortPage.nav_login_Butonu.isDisplayed(),"Log in butonu görünür değil");
        extentTest=extentReports.createTest("Log-in butonu görünür testi.");
        extentTest=extentReports.createTest("Kullanıcı navbar öğelerini görür testi");

        String targetTitle=Driver.getDriver().getTitle();

        us0001QAConcortPage.concortPageYaziElementi.click();

        Assert.assertTrue(targetTitle.equals("Concort Hotel - Home"),"Concort Hotel Butonu Sayfayı yenilemedi.");
        extentTest=extentReports.createTest("Concort Hotel Yazısı click testi");

        us0001QAConcortPage.homeButonu.click();
        Assert.assertTrue(targetTitle.equals("Concort Hotel - Home"),"Home Butonu Sayfayı yenilemedi");
        extentTest=extentReports.createTest("Home butone click testi");

        us0001QAConcortPage.roomsButonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Rooms");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Rooms"));
        extentTest=extentReports.createTest("Rooms butonu Concort Hotel - Rooms sayfasina yönlendirdi");


        us0001QAConcortPage.restaurantButonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Content : Our Restaurant");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Content : Our Restaurant"));
        extentTest=extentReports.createTest("Restaurant. Butonu ,Concort Hotel - Content : Our Restaurant sayfasina yönlendirdi");

        us0001QAConcortPage.aboutButonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Content : About");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Content : About"));
        extentTest=extentReports.createTest("About butonu Concort Hotel - Content : About sayfasina yönlendirdi");

        us0001QAConcortPage.blogButonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Blog");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Blog"));
        extentTest=extentReports.createTest("Blog butonu Concort Hotel - Blog sayfasina yönlendirdi.");

        us0001QAConcortPage.contactButonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Contact Form");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Contact Form"));
        extentTest=extentReports.createTest("Contact butonu Concort Hotel - Contact Form sayfasina götürdü.");

        us0001QAConcortPage.nav_login_Butonu.click();
        reusableMethods.switchToWindow("Concort Hotel - Log in");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Log in"));
        extentTest=extentReports.createTest("Log in butonu Concort Hotel - Log in sayfasina yönlendirdi.");

        Driver.closeDriver();

    }
   
}