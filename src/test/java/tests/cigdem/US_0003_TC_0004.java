package tests.cigdem;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage3;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0003_TC_0004 extends TestBaseRapor {

    QAConcortPage3 qaConcortPage3=new QAConcortPage3();
    @Test
    public void  positiveLoginTest(){

        //Name textbox'ına tıklayarak bir isim girmeli
        //Password textbox'ına tıklayarak bir parola girmeli
        //Email textbox'ına tıklayarak geçerli bir email girmeli
        //Fullname textbox'ına tıklayarak ad soyad girmeli
        //Phone No textbox'ına tıklayarak bir telefon no girmeli
        //Social Security Number textbox'ına tıklayarak no girilmeli
        //Driving License textbox'ına tıklayarak gerekli bilgiyi girin.
        //Select Country   textbox'ına tıklayarak ülke adını girin.
        //Select State textbox'ına tıklayarak şehir adını girin.
        //Address   textbox'ına tıklayarak adres bilgisini girin.
        //Working Sector textbox'ına tıklayarak meslek bilgisini girin.
        //Birth Day  textbox'ına tıklayarak doğum tarihini girin.
        //Tüm bilgiler tam ve doğru olarak girildikten sonra "Save" butonu tıklayarak diğer sayfaya
        //geçilebilmeli

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






    }


}

























