package tests.adem;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0008_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class US_0008_TC_0001 {

    @Test
    public void test() throws InterruptedException {
        US_0008_QAConcortPage qaConcortPage=new US_0008_QAConcortPage();
        //1- Hotel sayfsına gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //2- Sağ üstteki "log in" butonuna tıklayınız.
        qaConcortPage.firstlogIn.click();

        //3- Açılan pencere "username"i giriniz.
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //4- "password"u giriniz ve giriş yapınız.
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        //5- Açılan "ListOfUsers" sayfasının yanındaki "Hotel Management"a tıklayınız.
        qaConcortPage.logInButton.click();

        //6- "Hotel List"e tıklayınız.
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        //7- "List Of Hotels" sayfasında olduğunuzu test ediniz.
        Assert.assertTrue(qaConcortPage.basariliListOfHotels.isDisplayed());

        Driver.closeDriver();
}
}
