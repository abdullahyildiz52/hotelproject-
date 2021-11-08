package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0004_QAConcortPage extends TestBaseRapor {

    WebDriver driver;

    public US_0004_QAConcortPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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

    @FindBy (id = "menuHotels")
    public WebElement hotelManagement;

    @FindBy (xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;

    @FindBy (xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotels;

    @FindBy (xpath = "//div[@class='actions']")
    public WebElement addHotelButonu;

    @FindBy (id = "Code")
    public WebElement codeTextBox;

    @FindBy (id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement succesfullyYazisi;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement okButonu;

    @FindBy (xpath = "//label[@for='Code']")
    public WebElement codeError;

    @FindBy (xpath = "//label[@for='Name']")
    public WebElement nameError;

    @FindBy (xpath = "//label[@for='Email']")
    public WebElement emailError;

    @FindBy (xpath = "//input[@name='Code']")
    public WebElement hotelListCodeTextBox;

    @FindBy (xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButonu;

    @FindBy (xpath = "//td[@class='sorting_1']")
    public WebElement codeHotelListesi;


}
