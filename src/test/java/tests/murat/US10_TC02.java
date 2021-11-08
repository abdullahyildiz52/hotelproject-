package tests.murat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.US_0010_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US10_TC02 extends TestBaseRapor {


    @Test
    public void Test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US_0010_QAConcortPage us10_qaConcortPage =new US_0010_QAConcortPage();

        us10_qaConcortPage.ilkLoginLinki.click();

        us10_qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidNewUsername"));

        us10_qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));
        us10_qaConcortPage.logInButton.click();

        us10_qaConcortPage.addMusteriSaveButonu.click();

        Thread.sleep(2000);

        us10_qaConcortPage.addMusteriKabulOk.click();

        Actions actions=new Actions(Driver.getDriver());

        Thread.sleep(3000);

         actions.sendKeys(Keys.PAGE_UP).perform();
   //    sendKeys(Keys.PAGE_UP).
        Thread.sleep(3000);

       us10_qaConcortPage.addOdaTikla.click();

       actions.sendKeys(Keys.PAGE_DOWN).perform();
       Thread.sleep(2000);

      us10_qaConcortPage.addOtelSecimi.click();

     //  Thread.sleep(5000);
}
}
