package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0001_QAConcortPage {
    WebDriver driver;//--->1.adim

    public US_0001_QAConcortPage() {//--->2.adim

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

    @FindBy(linkText = "Log in")
    public WebElement firstlogIn;
    @FindBy(id = "UserName")
    public WebElement userName;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "btnSubmit")
    public WebElement logInButton;


    //--->navbar
    @FindBy(xpath = "(//nav[@id='ftco-navbar'])")
    public WebElement tumNavbar;

    @FindBy(xpath = "(//a[@class='navbar-brand'])")
    public WebElement concortPageYaziElementi;
    @FindBy(linkText = "Log in")
    public WebElement loginYaziElementi;


    @FindBy(id ="navHome" )
    public WebElement homeButonu;
    @FindBy(id ="navRooms" )
    public WebElement roomsButonu;
    @FindBy(id ="navRestaurant" )
    public WebElement restaurantButonu;
    @FindBy(id ="navAbout" )
    public WebElement aboutButonu;
    @FindBy(id ="navBlog" )
    public WebElement blogButonu;
    @FindBy(id ="navContact" )
    public WebElement contactButonu;
    @FindBy(id ="navLogon" )
    public WebElement nav_login_Butonu;

    //------->Booking Form munü
    @FindBy(xpath = "(//div[@class='col-lg-12'])")
    public WebElement bookingForm;
    @FindBy(xpath = "(//input[@id='checkin_date'])")
    public WebElement checkinDate;
    @FindBy(xpath = "(//input[@id='checkout_date'])")
    public WebElement checkoutDate;
    @FindBy(xpath = "(//input[@type='submit'])")
    public WebElement checkAvailabilityButon;

    //rooms Sayfası
    @FindBy(id = "checkin_date")
    public WebElement roomsCheckinDate;

    @FindBy(id = "checkout_date")
    public WebElement roomsCheckoutDate;

    @FindBy(xpath = "(//h2[@class='mb-4'])[3]")
    public WebElement ourRoomsYaziElementi;

    //---->footer
    @FindBy(xpath = "(//footer[@class='ftco-footer ftco-bg-dark ftco-section'])")
    public WebElement footerMenu;
    @FindBy(xpath = "(//h2[@class='ftco-heading-2'])[2]")
    public WebElement usefulYaziElementi;
    @FindBy(xpath = "(//div[@class='ftco-footer-widget mb-4'])[3]")
    public WebElement haveAQuestions;

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

