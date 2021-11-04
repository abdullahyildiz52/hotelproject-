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