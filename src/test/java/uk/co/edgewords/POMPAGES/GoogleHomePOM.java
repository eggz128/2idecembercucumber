package uk.co.edgewords.POMPAGES;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePOM {

    WebDriver driver;

    public GoogleHomePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id = "L2AGLb")
    WebElement acceptCookiesButton;

    @FindBy(css = "input[name=q]")
    WebElement searchField;

    public void acceptCookies(){
        acceptCookiesButton.click();
    }

    public void search(String searchTerm){
        searchField.sendKeys(searchTerm + Keys.ENTER);
    }

}
