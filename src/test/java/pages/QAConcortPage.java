package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

 WebDriver driver;//--->1.adim

 public QAConcortPage() {//--->2.adim
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

 @FindBy(linkText = "Log in")
 public WebElement ilkLoginLinki;

 @FindBy(xpath ="//span[@class='btn btn-primary py-3 px-5']")
 public WebElement createNewAccountButonu;

 @FindBy(id="Address")
 public WebElement adressTextBox;

 @FindBy(id="UserName")
 public WebElement newusernameKutusu;

 @FindBy(id="Password")
 public WebElement newpasswordKutusu;

 @FindBy(id="btnSubmit")
 public WebElement loginButonu;

 @FindBy(xpath="//span[text()='ListOfUsers']")
 public WebElement basariliGirisYaziElementi;

 @FindBy (xpath = "//*[.='Try again please']")
 public WebElement loginFailedYazisi;

 @FindBy(xpath = "//span[text()='Hotel Management']")
 public WebElement hotelManagementLinki;

 @FindBy(partialLinkText = "Hotel List")
 public WebElement hotelListLink;

 @FindBy(xpath = "//span[text()='Add Hotel ']")
 public WebElement addHotelLink;

 @FindBy(id="Code")
 public WebElement addHotelCodeKutusu;

 @FindBy(id="IDGroup")
 public WebElement addHotelDropdown;

 @FindBy(id="IDCountry")
 public WebElement addCountryDropdown;

 @FindBy(id="IDState")
 public WebElement addStateDropdown;



 @FindBy(id="btnSubmit")
 public WebElement addHotelSave;

 @FindBy(xpath="//div[@class='bootbox-body']")
 public WebElement addHotelSuccesfullYazisi;

 @FindBy(xpath="//button[@class='btn btn-primary']")
 public WebElement addHotelAllertOk;

 @FindBy(partialLinkText = "Hotel Rooms")
 public WebElement hotelRoomsLinki;

 @FindBy(xpath ="//span[text()='Add Hotelroom ']")
 public WebElement addHotelRoomButonu;

 @FindBy(id="IDHotel")
 public WebElement addRoomIdDropdown;

 @FindBy(id="IDGroupRoomType")
 public WebElement addRoomType;

 @FindBy(id="btnSubmit")
 public WebElement addRoomSaveButonu;

 @FindBy(xpath = "//div[@class='bootbox-body']")
 public WebElement addRoomSuccessfulYazisi;

 @FindBy(xpath = "//button[@class='btn btn-primary']")
 public WebElement addRoomAllertOkButonu;

 @FindBy(linkText = "Hotelrooms")
 public WebElement addroomHotelRoomsLinki;

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