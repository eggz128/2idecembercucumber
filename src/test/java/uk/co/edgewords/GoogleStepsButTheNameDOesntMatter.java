package uk.co.edgewords;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.edgewords.POMPAGES.GoogleHomePOM;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;



public class GoogleStepsButTheNameDOesntMatter {


    String pageTitle;

    private SharedDictionary myDict;

    private WebDriver driver;
    public GoogleStepsButTheNameDOesntMatter(SharedDictionary myDict) {
        this.myDict = myDict;
        this.driver = (WebDriver)myDict.readDict("mydriver");
    }

    @Given("^(?:i|I) am on (?i)Goog(?-i)le$")
    @Given("I have visited Google")
    public void i_am_on_google() {

        driver.get("https://www.google.co.uk/");
        //Need to accept cookies
        GoogleHomePOM home = new GoogleHomePOM(driver);
        home.acceptCookies();
        pageTitle = driver.getTitle();
        //driver.switchTo().alert().dismiss();
    }
    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchTerm) {
        GoogleHomePOM home = new GoogleHomePOM(driver);
        home.search(searchTerm);

        System.out.println(pageTitle);
    }


//    //Incorrect method generation from IntelliJ's gherkin plugin
//    //Wrong number of method args
//    @Then("{string} {int} is the top result")
//    public void edgewordsIsTheTopResult(int arg0) {
//    }

    @Then("{string} {int} is the top result")
    public void is_the_top_result(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I see in the results")
    public void i_see_in_the_results(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        String searchResults = driver.findElement(By.cssSelector("#rso")).getText();
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);

        for(var row : data){
            assertThat(searchResults, containsString(row.get("title")));
            assertThat(searchResults, containsString(row.get("url")));
        }

    }


}
