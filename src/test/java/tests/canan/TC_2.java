package tests.canan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import pages.US_0006QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0006_TC2 extends TestBaseRapor {


    QAConcortPage qaConcortPage=new QAConcortPage();
    US_0006QAConcortPage us_0006QAConcortPage=new US_0006QAConcortPage();
    @Test
    public void test2() throws InterruptedException {
        //List of hotelrooms sayfasındaki hotelin detail kısmına tıklandığında Edit hotelroom sayfasına gidebilmeliyim
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest=extentReports.createTest("Edit hotel sayfasina gidis","Edit Hotel sayfasina ulasmaliyim");
        us_0006QAConcortPage.firstlogIn.click();
        us_0006QAConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us_0006QAConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us_0006QAConcortPage.logInButton.click();
        us_0006QAConcortPage.hotelManagement.click();
        us_0006QAConcortPage.hotelRooms.click();
        us_0006QAConcortPage.detailsButton.click();

        SoftAssert softAssert=new SoftAssert();
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Admin - List Of Hotelrooms";
        softAssert.assertEquals(actualTitle,expectedTitle,"yazi istendigi gibi degil");
        System.out.println("Sayfada ki title: "+actualTitle.toUpperCase());
    }


    }

