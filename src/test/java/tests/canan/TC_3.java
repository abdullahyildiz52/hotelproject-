package tests.canan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import pages.US_0006_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_3 extends TestBaseRapor {

    QAConcortPage qaConcortPage=new QAConcortPage();
    US_0006_QAConcortPage us_0006QAConcortPage=new US_0006_QAConcortPage();


    @Test
    public void test3() throws InterruptedException {
        //List of hotelrooms sayfasındaki hotelin detail kısmına tıklandığında Edit hotelroom sayfasına gidebilmeliyim
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        us_0006QAConcortPage.firstlogIn.click();
        us_0006QAConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        us_0006QAConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        us_0006QAConcortPage.logInButton.click();
        us_0006QAConcortPage.hotelManagement.click();
        us_0006QAConcortPage.hotelRooms.click();
        us_0006QAConcortPage.detailsButton.click();
        us_0006QAConcortPage.nameBox.clear();

        us_0006QAConcortPage.nameBox.sendKeys("110011");
         Actions actions=new Actions(Driver.getDriver());
         Thread.sleep(1000);
         actions.sendKeys(Keys.PAGE_DOWN).perform();
         Thread.sleep(1000);
        us_0006QAConcortPage.saveButton.click();
        us_0006QAConcortPage.buttonOk.click();


    }

    }
