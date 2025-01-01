package stepdifinitions;

import base.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Google.FlipkartHomePage_PF;

public class SearchSteps extends Base {

    public FlipkartHomePage_PF homePagePf;

      @Before
    public void setup(){
        Base base = new Base();
        base.setup();
    }

    @Given("I am on the Flipkart homepage")
    public void i_am_on_the_flipkart_homepage() {
        System.out.println("Driver in SearchSteps: " + driver); // Check if driver is null
        homePagePf = new FlipkartHomePage_PF(driver);
        String expected = "https://www.flipkart.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expected, "Not on the Flipkart page");
    }

    @When("I type {string} into the search bar")
    public void i_type_into_the_search_bar(String string) {
        homePagePf.SearchSendKeys(string);
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        homePagePf.clickOnSearchButton();
    }

    @Then("I should be navigated to a page with Harry Potter Search Results")
    public void i_should_be_navigated_to_a_page_with_harry_potter_search_results() {
        String actual = homePagePf.getSearchBarText();
        String expected = "Harry Potter";
        Assert.assertEquals(actual, expected, "Failed");
    }
}
