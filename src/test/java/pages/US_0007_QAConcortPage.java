package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0007_QAConcortPage {
    WebDriver driver;//--->1.adim

    public US_0007_QAConcortPage() {//--->2.adim
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
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;
    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLinki;
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelroomlinki;
    @FindBy(xpath ="//a[@class='btn btn-xs default']")
    public WebElement detailsButton;
    @FindBy(xpath ="//div[@class='caption']")
    public WebElement editHotelRoom;
    @FindBy(xpath ="//button[@type='submit']" )
    public WebElement deleteButonu;
    @FindBy(xpath ="//input[@id='Price']")
    public WebElement price;
    @FindBy(xpath ="(//button[@class='btn green'])")
    public WebElement save;
    @FindBy(xpath ="( //input[@placeholder='Code']")
    public WebElement Code;
    @FindBy(xpath ="//button[@id='btnDelete']" )
    public WebElement delete;


    @FindBy(xpath ="(//div[@class='modal-body'])")
     public WebElement basarılıeditYazısı;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement okButon;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement onayButonu;
    @FindBy(xpath ="//div[@class='bootbox-body']" )
    public WebElement deleteAlertMesaj;
      String printData(int satir, int sutun) {
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
