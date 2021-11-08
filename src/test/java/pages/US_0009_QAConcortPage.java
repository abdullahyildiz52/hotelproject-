package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_0009_QAConcortPage {


    WebDriver driver;//--->1.adim

    public US_0009_QAConcortPage() {//--->2.adim
        PageFactory.initElements(Driver.getDriver(), this);//--->3.adim
    }


    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogIn.click();
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();
    }
    // 1.) Anasayfa Login butonu
    @FindBy(linkText = "Log in")
    public WebElement firstlogIn;

    // 2.) Login icin UserName kutusu
    @FindBy(id = "UserName")
    public WebElement userName;

    // 3.) Login icin Password kutusu
    @FindBy(id = "Password")
    public WebElement password;

    // 4.) Login icin submit butonu
    @FindBy(id = "btnSubmit")
    public WebElement logInButton;

    // 5.) Hotel management
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    //6.) Room Reservation
    @FindBy(xpath = "//a[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservation;

    // 7.) List of Reservation yazisinin locateri
    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfHotelReservationsYazisi;

    //8.) DETAILS yazisinin locateri
    @FindBy(xpath = "//a[@href='./RoomReservationAdmin/Edit?Id=1']")
    public  WebElement detailsYazisi;

    // 9.) Edit HotelroomReservation gorulmeli
    @FindBy(xpath = "(//div[@class='caption'])[1]")
    public WebElement editHotelroomReservationYazisi;

    // 10 .) Price Locateri
    @FindBy(xpath = "//input[@id='Price']")
    public WebElement price;

    // 11 .) AdultAmount locateri
    @FindBy(xpath = "//input[@id='AdultAmount']")
   public WebElement adultAmount;

    // 12 .) ChildrenAmount locateri
    @FindBy(xpath = "//input[@id='ChildrenAmount']")
    public WebElement childrenAmount;

    // 13 .) ContactNameSurname locateri
    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurname;


    // 14 .) ContactPhone locateri
    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement contactPhone;

    // 15 .) Contact Email locateri
    @FindBy(xpath="//input[@id='ContactEmail']")
    public WebElement contactEmail;

    // 16 .) Notes locatero
    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement notes;
    //input[@id='Notes']

    // 17 .) Save Butonu locateri
    @FindBy(xpath = "//button[@class='btn green']")
    public WebElement btnGreen;

    // 18 .) Delete Butonu locateri
    @FindBy(xpath = "//button[@id='btnDelete']")
    public WebElement btnDelete;


    public String printData(int satir, int sutun) {
        // ornekteki haliyle 3.satir, 5.sutundaki elemani yazdiralim
        //  String xpath= //tbody//tr[3]//td[5]
        // degismeyecek kisimlari String, degisecek kisimlari ise parametre ismi olarak yazdik
        String xpath= "//tbody//tr[" + satir +"]//td["+ sutun + "]";
        //System.out.println(xpath);

        // satir no : 3, sutun no : 5
        //System.out.println("satir no : "+ satir+ " sutun no : " + sutun);

        // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no  "+ satir+ ", sutun no : " + sutun + "'deki data : " + istenenData );

        return istenenData;
    }

}