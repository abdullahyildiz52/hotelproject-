package tests.adem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0008_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
public class US_0008_TC_0002 {
    @Test
    public void test() throws InterruptedException {
        US_0008_QAConcortPage qaConcortPage = new US_0008_QAConcortPage();
        //1- Hotel sayfsına gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //2- Sağ üstteki "log in" butonuna tıklayınız.
        qaConcortPage.firstlogIn.click();

        //3- Açılan pencere "username"i giriniz.
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //4- "password"u giriniz ve giriş yapınız.
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();
        //5- Açılan "ListOfUsers" sayfasının yanındaki "Hotel Management"a tıklayınız.
        qaConcortPage.hotelManagementLinki.click();

        //6- "Room reservations"e tıklayınız.
        qaConcortPage.roomReservationLink.click();

        //7- "Add Room Reservation" tıklayınız.
        qaConcortPage.addRoomReservationLink.click();

        //8-"Create Hotelroomreservatıon" sayfasında olduğunuzu test edin.
        Assert.assertTrue(qaConcortPage.basariliCreateRoomReservationPage.isDisplayed());

        Driver.closeDriver();

    }
    }
