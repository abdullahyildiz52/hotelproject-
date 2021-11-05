package tests.cigdem;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage3;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0001 extends TestBaseRapor {
    QAConcortPage3 qaConcortPage3=new QAConcortPage3();
    @Test
    public void  positiveLoginTest(){
        //Log in butonuna tıklayın
        Driver.getDriver().get((ConfigReader.getProperty("CHQAUrl")));
        qaConcortPage3.firstlogIn.click();

        //qaConcortPage3.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        //qaConcortPage3.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        //Log in sayfasında "Create a new account"butonuna tıklayın
        qaConcortPage3.Createanewaccount.click();


        //"Create a new account"butonuna tıkladığında "Registration Formu"görmeli
        Assert.assertTrue(qaConcortPage3.RegistrationForm.isDisplayed());





    }


}



