package tests.murat;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0010_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US10_TC01 extends TestBaseRapor {

    @Test
    public void Test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        US_0010_QAConcortPage us10_qaConcortPage=new US_0010_QAConcortPage();

        us10_qaConcortPage.ilkLoginLinki.click();

        us10_qaConcortPage.createNewAccountButonu.click();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
       /*
        Faker faker=new Faker();
        actions.
                click(us10_qaConcortPage.newusernameKutusu).
                sendKeys(faker.name().username()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password(6,7,true,true,true)).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.idNumber().ssnValid()).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAValidNewDrivingLisance")).
                sendKeys(Keys.TAB).perform();
                Select select=new Select(us10_qaConcortPage.addCountryDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewCountryOption"));
        Select select1=new Select(us10_qaConcortPage.addStateDropdown);
        select1.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewStateOption"));
        actions.sendKeys(Keys.TAB).
       sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB). perform();
        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewWorkSector")).perform();
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewBirthDay")).perform();
        actions.click(us10_qaConcortPage.addHotelSave).perform();
    Assert.assertTrue(us10_qaConcortPage.addHotelSuccesfullYazisi.isDisplayed());
     //  System.out.println(us10_qaConcortPage.basarılıKayıtSayfasıYazısı.getText());
    //   Assert.assertTrue(us10_qaConcortPage.basarılıKayıtSayfasıYazısı.isDisplayed())
        //           sendKeys(faker.address().zipCode()).
        //        sendKeys(Keys.TAB).
        //        sendKeys(Keys.TAB).
        //        sendKeys(faker.address().fullAddress()).
      //          sendKeys(Keys.TAB).
       // Select select=new Select(us10_qaConcortPage.addHotelDropdown);
      //  select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));

        //8. Save butonuna tıklayın.
       // actions.sendKeys(Keys.PAGE_DOWN);

        */
       // us10_qaConcortPage.newusernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidNewUsername"));

        actions.
                click(us10_qaConcortPage.newusernameKutusu).
                sendKeys(faker.name().username()).perform();

        us10_qaConcortPage.newpasswordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().emailAddress()).perform();

       // actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewEmail")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewFullName")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewPhoneNo")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewSSN")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewDrivingLisance")).perform();

        Select select=new Select(us10_qaConcortPage.addCountryDropdown);

        select.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewCountryOption"));

        Select select1=new Select(us10_qaConcortPage.addStateDropdown);

        select1.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewStateOption"));

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewAddres")).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewWorkSector")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewBirthDay")).perform();

        actions.click(us10_qaConcortPage.addHotelSave).perform();

        System.out.println(us10_qaConcortPage.addHotelSuccesfullYazisi.getText());

    Thread.sleep(2000);
        Assert.assertTrue(us10_qaConcortPage.addHotelSuccesfullYazisi.isDisplayed());

       // Driver.closeDriver();

    }
}


