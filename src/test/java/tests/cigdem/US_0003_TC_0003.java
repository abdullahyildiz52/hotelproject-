package tests.cigdem;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import pages.QAConcortPage3;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0003 extends TestBaseRapor {
    QAConcortPage3 qaConcortPage3=new QAConcortPage3();
    @Test
    public void  positiveLoginTest(){

        //Register sayfasında(https://qa-environment.concorthotel.com/Account/Register)hiçbir alan
        //boş bırakılmamalıdır
        //Geçerli bir isim harflerden oluşmalı ve boş bırakılamamalıdır
        //Kullanıcı "@"ve "."karakterlerini içeren geçerli bir email girmelidir
        //Telefon numarasında "-"karakteri dışında herhangi bir özel karakter kullanılamamalıdır
        //Geçerli bir adresi tanımlamak için harfler ve rakamlar kullanılabilmelidir
        //Kullanıcı "-"işaretine uygun olarak ,10 haneli zorunlu telefon numarası alanını doldurmalıdır


        //UserName textbox'ına tıklayarak bir isim girmeli
     //   Driver.getDriver().get((ConfigReader.getProperty("CHQAUrl")));
       // qaConcortPage3.firstlogIn.click();
      //  qaConcortPage3.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
      //  qaConcortPage3.userName.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
      //  qaConcortPage3.userName.click();
     //   Assert.assertTrue(qaConcortPage3.RegistrationForm.isDisplayed());
        Driver.getDriver().get("https://qa-environment.concorthotel.com/Account/Register");

        qaConcortPage3.userName.sendKeys("ali");
        qaConcortPage3.password.sendKeys("123456");
        qaConcortPage3.Email.sendKeys("ali@gmail.com");
        qaConcortPage3.FullName.sendKeys("Osman baba");
        qaConcortPage3.PhoneNo.sendKeys("5355355355");
        qaConcortPage3.SocialSecurityNumber.sendKeys("123456789");
        qaConcortPage3.DrivingLicense.sendKeys("c");
        qaConcortPage3.Country.sendKeys("a");
        qaConcortPage3.State.sendKeys("--");
        qaConcortPage3.Address.sendKeys("bilgisokakno:1");
        qaConcortPage3.WorkingSector.sendKeys("IT");
        qaConcortPage3.BirthDate.sendKeys("1/11/1985");


        //Tüm bilgiler tam ve doğru olarak girildikten sonra "Save" butonu tıklayarak diğer sayfaya
        //geçilebilmeli ("user data was inserted successfully yazısını görmeli")

        qaConcortPage3.save.click();
        Assert.assertTrue(qaConcortPage3.RegistrationForm.isDisplayed());
        extentTest=extentReports.createTest("Tüm bilgiler tam ve doğru olarak girildikten sonra Save butonu tıklama testi");

    }
}
