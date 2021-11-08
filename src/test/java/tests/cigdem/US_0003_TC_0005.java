package tests.cigdem;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0003_QAConcortPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0005 extends TestBaseRapor {
    US_0003_QAConcortPage qaConcortPage3 = new US_0003_QAConcortPage();

    @Test
    public void positiveLoginTest() {

     //Register sayfasında textboxlar doğru olarak doldurulduktan sonra "save" butonuna tıklanmalı

        Driver.getDriver().get("https://qa-environment.concorthotel.com/Account/Register");
        qaConcortPage3.save.click();
        Assert.assertTrue(qaConcortPage3.RegistrationForm.isDisplayed());
        extentTest=extentReports.createTest("Register sayfasında textboxlar doğru olarak doldurulduktan sonra save butonuna tıklanmalı testi");

    }
}
