package pages;

import com.github.javafaker.Country;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage3 {
    WebDriver driver;//--->1.adim

    public QAConcortPage3() {//--->2.adim


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


    @FindBy(xpath ="//input[@id='UserName']")
    public WebElement userName;


    @FindBy(id = "Password")
    public WebElement password;

    @FindBy (xpath="//input[@id='NameSurname']")
    public WebElement FullName;

    @FindBy(id = "label")
    public WebElement email;

    @FindBy(id = "btnSubmit")
    public WebElement logInButton;

    @FindBy(xpath ="//span[@class='btn btn-primary py-3 px-5']")
     public WebElement Createanewaccount;

    @FindBy(xpath = "//h2[@class='mb-4']")
   public WebElement RegistrationForm;


    @FindBy (id = "IDCountry")
   public WebElement addCountryDropdown;

    @FindBy (id = "IDState")
    public WebElement addStateDropdown;




    @FindBy (id = "Email")
    public WebElement Email;



    @FindBy (id = "Birth Date")
    public WebElement birthdate;

    @FindBy (id = "btnSubmit")
    public WebElement save;

    @FindBy(xpath = "//n-primary[@class='py-3']")
    public WebElement getSave;

    @FindBy(xpath="//input[@id='PhoneNo']")
     public WebElement PhoneNo;
    @FindBy (id = "form-control required email")
    public WebElement getEmail;
       @FindBy (xpath ="//input[@id='SSN']")
        public WebElement SocialSecurityNumber;
     @FindBy (xpath ="//input[@id='DrivingLicense']")
     public WebElement DrivingLicense;

     @FindBy (xpath ="//select[@title='Select State']")
     public WebElement State;

    @FindBy (xpath = "//select[@name='IDCountry']")
     public WebElement Country;

    @FindBy (xpath ="//input[@id='Address']")
    public WebElement Address;
   @FindBy (xpath="//input[@id='WorkingSector']")
   public WebElement WorkingSector;
   @FindBy (xpath="//input[@id='BirthDate']")
   public WebElement BirthDate;

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

