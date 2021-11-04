package tests.canan;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import pages.US_0006QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class TC_1 extends TestBaseRapor {


   QAConcortPage qaConcortPage=new QAConcortPage();
   US_0006QAConcortPage us_0006QAConcortPage=new US_0006QAConcortPage();
    //Açılan pencerede Hotel Management->Hotel Rooms tıklandığında "LIST OF HOTELROOMS" sayfasına gelmeliyim

    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        us_0006QAConcortPage.firstlogIn.click();
        us_0006QAConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us_0006QAConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us_0006QAConcortPage.logInButton.click();
        us_0006QAConcortPage.hotelManagement.click();
        us_0006QAConcortPage.hotelRooms.click();
        extentTest=extentReports.createTest("HotelRooms sayfasina gidis","HotelRooms sayfasina ulasmaliyim");

        SoftAssert softAssert=new SoftAssert();
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="List Of Hotelrooms";
        softAssert.assertEquals(actualTitle,expectedTitle,"yazi istendigi gibi degil");
        System.out.println("Sayfada ki title: "+actualTitle.toUpperCase());
        System.out.println(actualTitle);
    }

}


//        List of hotelrooms sayfasındaki hotelin detail kısmına tıklandığında Edit hotelroom sayfasına gidebilmeliyim
//        Edit Hotelroom sayfasındaki room bilgileri güncellenebilmeli
//        Save butonuna tıklandığında başarılı yazısı görünmeli
//        Kaydedilen Room Listede görünmeli