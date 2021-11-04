package tests.muhammed;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.Pages_US_0005;
import pages.QAConcortPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class MethodsClass extends TestBaseRapor {

    QAConcortPage qaConcortPage= new QAConcortPage();
    Faker faker=new Faker();
    Pages_US_0005 pages_US_0005= new Pages_US_0005();

    public void websiteGirisToHotelList(){

        extentTest=extentReports.createTest("WebSite giris","Hotel list sayfasina kadar ulasmaliyim");

        qaConcortPage.ConcortHotelLogin();
        extentTest.pass("Concort hotel sayfasina giris yapildi");

        pages_US_0005.hotelManagement.click();

        pages_US_0005.hotelList.click();

        Assert.assertTrue(pages_US_0005.listOfHotelsYazisi.isDisplayed(),"LIST OF HOTELS basligi gorunmuyor");
        extentTest.pass("List of hotels sayfasina gidildi");

    }

    public void hotelListToEditHotel(){

        extentTest=extentReports.createTest("Edit hotel sayfasina gidis","Edit Hotel sayfasina ulasmaliyim");

        WebElement detailButton=Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-xs default']"));
        detailButton.click();

        ReusableMethods.switchToWindow("Admin - Edit Hotel");

        Assert.assertTrue(pages_US_0005.editHotelYazisi.isDisplayed(),"Edit Hotel basligi gorunmuyor");
        extentTest.pass("Edit hotel sayfasina gidildi");
    }

    public void editHotelPageOfCodeBox()  {

        extentTest=extentReports.createTest("CodeBox guncelleme testi","CodeBox guncellenmeli");

        String code=String.valueOf(faker.number().numberBetween(1,9999));

        pages_US_0005.codeBox.clear();
        pages_US_0005.codeBox.sendKeys(code);
        pages_US_0005.codeBox.sendKeys(Keys.ENTER);

        ReusableMethods.waitForVisibility(pages_US_0005.succesfullyAlert,1);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("CodeBox'a bilgiler girilip onaylandi");


        ReusableMethods.switchToWindow("Admin - List Of Hotels");

        Driver.getDriver().navigate().refresh();

        WebElement listOfHotelsCodeCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]"));

        Assert.assertEquals(listOfHotelsCodeCells.getText(),code,"Listedeki code ile degistirilen code uyusmuyor");
        extentTest.pass("CodeBox guncellemesi basarili");

    }

    public void editHotelPageOfNameBox(){

        extentTest=extentReports.createTest("NameBox guncelleme testi","NameBox guncellenmeli");

        String name=faker.name().name()+" Hotel";

        pages_US_0005.nameBox.clear();
        pages_US_0005.nameBox.sendKeys(name);
        pages_US_0005.nameBox.sendKeys(Keys.ENTER);


        ReusableMethods.waitForVisibility(pages_US_0005.succesfullyAlert,1);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("NameBox'a bilgiler girilip onaylandi");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");

        Driver.getDriver().navigate().refresh();

        WebElement listOfHotelsNameCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[3]"));

        Assert.assertEquals(listOfHotelsNameCells.getText(),name,"Listedeki name ile degistirilen name uyusmuyor");
        extentTest.pass("NameBox guncellemesi basarili");

    }

    public void editHotelPageOfAdressBox(){

        extentTest=extentReports.createTest("AdressBox guncelleme testi","AdressBox guncellenmeli");

        String address=faker.address().city();

        pages_US_0005.addressBox.clear();
        pages_US_0005.addressBox.sendKeys(address);
        pages_US_0005.addressBox.sendKeys(Keys.ENTER);

        ReusableMethods.waitForVisibility(pages_US_0005.succesfullyAlert,1);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("AdressBox'a bilgiler girilip onaylandi");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");

        Driver.getDriver().navigate().refresh();

        WebElement listOfHotelsAddressCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[4]"));

        Assert.assertEquals(listOfHotelsAddressCells.getText(),address,"Listedeki adress ile degistirilen adress uyusmuyor");
        extentTest.pass("AdressBox guncellemesi basarili");

    }

    public void editHotelPageOfPhoneBox(){

        extentTest=extentReports.createTest("PhoneBox guncelleme testi","PhoneBox guncellenmeli");

        String phone=faker.phoneNumber().phoneNumber();

        pages_US_0005.phoneBox.clear();
        pages_US_0005.phoneBox.sendKeys(phone);
        pages_US_0005.phoneBox.sendKeys(Keys.ENTER);

        ReusableMethods.waitForVisibility(pages_US_0005.succesfullyAlert,1);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("PhoneBox'a bilgiler girilip onaylandi");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");

        Driver.getDriver().navigate().refresh();

        WebElement listOfHotelsPhoneCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[5]"));

        Assert.assertEquals(listOfHotelsPhoneCells.getText(),phone,"Listedeki phone ile degistirilen phone uyusmuyor");
        extentTest.pass("PhoneBox guncellemesi basarili");

    }

    public void editHotelPageOfEmailBox(){

        extentTest=extentReports.createTest("EmailBox guncelleme testi","EmailBox guncellenmeli");

        String email=faker.internet().emailAddress();

        pages_US_0005.emailBox.clear();
        pages_US_0005.emailBox.sendKeys(email);
        pages_US_0005.emailBox.sendKeys(Keys.ENTER);

        ReusableMethods.waitForVisibility(pages_US_0005.succesfullyAlert,1);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("EmailBox'a bilgiler girilip onaylandi");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");

        Driver.getDriver().navigate().refresh();

        WebElement listOfHotelsEmailCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[6]"));

        Assert.assertEquals(listOfHotelsEmailCells.getText(),email,"Listedeki email ile degistirilen email uyusmuyor");
        extentTest.pass("EmailBox guncellemesi basarili");

    }

    public void editHotelPageOfGroupBox(){

        extentTest=extentReports.createTest("HotelTypeBox guncelleme testi","HotelTypeBox guncellenmeli");

        Actions actions=new Actions(Driver.getDriver());

        String code=pages_US_0005.codeBox.getAttribute("value");
        String name=pages_US_0005.nameBox.getAttribute("value");
        String address=pages_US_0005.addressBox.getAttribute("value");
        String phone=pages_US_0005.phoneBox.getAttribute("value");
        String email=pages_US_0005.emailBox.getAttribute("value");

        Select select=new Select(pages_US_0005.groupBoxDropDown);
        select.selectByVisibleText("Hotel Type1");
        String hotelType=select.getFirstSelectedOption().getText();

        actions
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(pages_US_0005.succesfullyAlert.isDisplayed(),"Basarili alerti görüntülenemiyor");
        extentTest.pass("HotelTypeBox'a bilgiler girilip onaylandi");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");
        Driver.getDriver().navigate().refresh();


        pages_US_0005.searchCodeBox.sendKeys(code);
        pages_US_0005.searchNameBox.sendKeys(name);
        pages_US_0005.searchAddressBox.sendKeys(address);
        pages_US_0005.searchPhoneBox.sendKeys(phone);
        pages_US_0005.searchEmailBox.sendKeys(email);
        pages_US_0005.searchButton.click();

        ReusableMethods.waitFor(1);
        WebElement listOfHotelsGroupCells=Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[7]"));

        ReusableMethods.waitFor(1);

        Assert.assertEquals(listOfHotelsGroupCells.getText(),hotelType,"Hotel Type uyusmuyor");
        extentTest.pass("HotelTypeBox guncellemesi basarili");

    }

    public void deleteHotel()  {

        extentTest=extentReports.createTest("otel silme testi","otel silinebilmeli");

        String code=pages_US_0005.codeBox.getAttribute("value");
        String name=pages_US_0005.nameBox.getAttribute("value");
        String address=pages_US_0005.addressBox.getAttribute("value");
        String phone=pages_US_0005.phoneBox.getAttribute("value");
        String email=pages_US_0005.emailBox.getAttribute("value");

        ReusableMethods.waitFor(2);
        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitForClickablility(pages_US_0005.deleteButton,1);

        pages_US_0005.deleteButton.click();

        pages_US_0005.alertOKButton.click();
        extentTest.pass("Otelin basarili silinme alerti gorundu");

        ReusableMethods.switchToWindow("Admin - List Of Hotels");
        Driver.getDriver().navigate().refresh();

        pages_US_0005.searchCodeBox.sendKeys(code);
        pages_US_0005.searchNameBox.sendKeys(name);
        pages_US_0005.searchAddressBox.sendKeys(address);
        pages_US_0005.searchPhoneBox.sendKeys(phone);
        pages_US_0005.searchEmailBox.sendKeys(email);
        pages_US_0005.searchButton.click();

        Assert.assertTrue(pages_US_0005.noDataAvailableInTableYazisi.isDisplayed(),"No data available in table yazisi gorunuyor");
        extentTest.pass("Otelin listeden silinmesi");

    }


}
