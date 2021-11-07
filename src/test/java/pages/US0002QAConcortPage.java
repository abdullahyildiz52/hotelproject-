package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US0002QAConcortPage  {
    WebDriver driver;//--->1.adim

    public US0002QAConcortPage() {//--->2.adim
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

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement ConcortHotelYazisi;

    @FindBy(linkText = "Log in")
    public WebElement firstlogIn;
    @FindBy(id = "btnSubmit")
    public WebElement secondLogIn;
    @FindBy(xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement CreateANewAccount;
    @FindBy(id = "UserName")
    public WebElement userName;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "btnSubmit")
    public WebElement logInButton;
    @FindBy(linkText = "Log in")
    public  WebElement ucuncuLOgIn;
    @FindBy (xpath = "//h3[text()='User Menu']")
    public WebElement userMenu;
    @FindBy(linkText = "Reservations")
    public WebElement reservations;
    @FindBy(linkText = "Profile")
    public WebElement profile;
    @FindBy(linkText = "Change Password")
    public WebElement changePassword;
    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement listOfUsers;
    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement hataMesaji;
}
