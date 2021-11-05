package tests.cigdem;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage3;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0005 extends TestBaseRapor {
    QAConcortPage3 qaConcortPage3 = new QAConcortPage3();

    @Test
    public void positiveLoginTest() {

     //Register sayfasında textboxlar doğru olarak doldurulduktan sonra "save" butonuna tıklanmalı

        Driver.getDriver().get("https://qa-environment.concorthotel.com/Account/Register");
        qaConcortPage3.save.click();
        Assert.assertTrue(qaConcortPage3.RegistrationForm.isDisplayed());


    }
}
