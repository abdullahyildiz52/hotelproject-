package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Pages_US_0005 {



    public Pages_US_0005(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText ="Hotel List" )
    public WebElement hotelList;

    @FindBy(xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelsYazisi;

    @FindBy(xpath ="//a[contains(text(),'Edit Hotel')] " )
    public WebElement editHotelYazisi;


    @FindBy(id ="Code" )
    public WebElement codeBox;

    @FindBy(id ="Name" )
    public WebElement nameBox;

    @FindBy(id ="Address" )
    public WebElement addressBox;

    @FindBy(id ="Phone" )
    public WebElement phoneBox;

    @FindBy(id ="Email" )
    public WebElement emailBox;

    @FindBy(className ="bootbox-body")
    public WebElement succesfullyAlert;

    @FindBy(id = "IDGroup")
    public WebElement groupBoxDropDown;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement searchCodeBox;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement searchNameBox;

    @FindBy(xpath = "//input[@name='Address']")
    public WebElement searchAddressBox;

    @FindBy(xpath = "//input[@name='Phone']")
    public WebElement searchPhoneBox;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement searchEmailBox;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButton;

    @FindBy(id = "btnDelete")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement alertOKButton;

    @FindBy(xpath = "//td[text()='No data available in table']")
    public WebElement noDataAvailableInTableYazisi;




}
