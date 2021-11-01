package tests.murat;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

public class C01 {

    @Test
    public void Test()  {

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.createNewAccountButonu.click();

        Actions actions=new Actions(Driver.getDriver());

       /*

        Faker faker=new Faker();
        actions.
                click(qaConcortPage.newusernameKutusu).
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

                Select select=new Select(qaConcortPage.addCountryDropdown);

        select.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewCountryOption"));


        Select select1=new Select(qaConcortPage.addStateDropdown);

        select1.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewStateOption"));

        actions.sendKeys(Keys.TAB).

        sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB). perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewWorkSector")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewBirthDay")).perform();

        actions.click(qaConcortPage.addHotelSave).perform();


    Assert.assertTrue(qaConcortPage.addHotelSuccesfullYazisi.isDisplayed());


     //  System.out.println(qaConcortPage.basarılıKayıtSayfasıYazısı.getText());

    //   Assert.assertTrue(qaConcortPage.basarılıKayıtSayfasıYazısı.isDisplayed());








        //           sendKeys(faker.address().zipCode()).
        //        sendKeys(Keys.TAB).

        //        sendKeys(Keys.TAB).
        //        sendKeys(faker.address().fullAddress()).
      //          sendKeys(Keys.TAB).



       // Select select=new Select(qaConcortPage.addHotelDropdown);
      //  select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));

        //8. Save butonuna tıklayın.
       // actions.sendKeys(Keys.PAGE_DOWN);

        */
        qaConcortPage.newusernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidNewUsername"));


        qaConcortPage.newpasswordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));


        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewEmail")).perform();


        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewFullName")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewPhoneNo")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewSSN")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewDrivingLisance")).perform();


        Select select=new Select(qaConcortPage.addCountryDropdown);

        select.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewCountryOption"));


        Select select1=new Select(qaConcortPage.addStateDropdown);

        select1.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewStateOption"));

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewAddres")).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewWorkSector")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewBirthDay")).perform();

        actions.click(qaConcortPage.addHotelSave).perform();


        System.out.println(qaConcortPage.addHotelSuccesfullYazisi.getText());

        Assert.assertTrue(qaConcortPage.addHotelSuccesfullYazisi.isDisplayed());


        //Driver.closeDriver();

    }
}


