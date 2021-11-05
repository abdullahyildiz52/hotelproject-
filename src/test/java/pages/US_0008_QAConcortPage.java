package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0008_QAConcortPage {

 WebDriver driver;//--->1.adim

 public US_0008_QAConcortPage() {//--->2.adim
  PageFactory.initElements(Driver.getDriver(), this);//--->3.adim
 }





 public void ConcortHotelLogin(){
  Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
  US_0008_QAConcortPage qaConcortPage=new US_0008_QAConcortPage();
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
 @FindBy(partialLinkText = "Hotel List")
 public WebElement hotelListLink;
 @FindBy(xpath = "//span[text()='List Of Hotels']")
 public WebElement basariliListOfHotels;
 @FindBy(partialLinkText = "Room reservations")
 public WebElement roomReservationLink;
 @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]")
 public WebElement basariliCreateRoomReservationPage;
 @FindBy(xpath = "//span[text()='Add Room Reservation ']")
 public WebElement addRoomReservationLink;
 @FindBy(id = "IDUser")
 public WebElement IDUserDropDown;
 @FindBy(id = "IDHotelRoom")
 public WebElement IDhotelRoomDropDown;
 @FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div")
 public WebElement basariliAddRoomYazisi;
 @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/button")
 public WebElement addRoomOkButon;
 @FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/ul/li[2]/a")
 public WebElement backRoomReservation;
 @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/tbody/tr/td[9]")
 public WebElement baslik2satir9sutun;
 @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[14]/div/button/i")
 public WebElement searchButon;
 @FindBy(xpath = "//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[9]/input")
 public WebElement contactName;


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