package pages.Google;

import enums.WaitStrat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

public class FlipkartHomePage_PF {

    public WebDriver driver;


    @FindBy(xpath = "//a[@title = 'Flipkart']")
    private WebElement leftTitle;

    @FindBy(xpath = "//input[contains(@title,'Search')]")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[text() = 'Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@title = 'Cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@aria-label = 'Grocery']")
    private WebElement grocery;



    public FlipkartHomePage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnTitle() {
        WaitUtils.applyWait(driver, leftTitle, WaitStrat.CLICKABLE);
        this.leftTitle.click();
    }

    public void clickOnSearchButton() {
        WaitUtils.applyWait(driver, searchButton, WaitStrat.CLICKABLE);
        this.searchButton.click();
    }

    public void clickOnLogin() {
        WaitUtils.applyWait(driver, loginButton, WaitStrat.CLICKABLE);
        this.loginButton.click();
    }

    public void clickOnCartButton() {
        WaitUtils.applyWait(driver, cartButton, WaitStrat.CLICKABLE);
        this.cartButton.click();
    }

    public void clickOnGrocery() {
        WaitUtils.applyWait(driver, grocery, WaitStrat.CLICKABLE);
        this.grocery.click();
    }

    public void SearchSendKeys(String keys) {
        WaitUtils.applyWait(driver, searchBar, WaitStrat.VISIBLE);
        this.searchBar.sendKeys(keys);
    }

    public String getSearchBarText(){
        return searchBar.getAttribute("value");
    }


}
