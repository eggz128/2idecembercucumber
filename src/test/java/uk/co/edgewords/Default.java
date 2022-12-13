package uk.co.edgewords;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;



public class Default {

    private SharedDictionary myDict;

    private WebDriver driver;
    public Default(SharedDictionary myDict) {
        this.myDict = myDict;
        this.driver = (WebDriver)myDict.readDict("mydriver");
    }

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

    @When("{string} is the top result")
    public void is_the_top_result(String expectedResult) {
        //ToDo: probably need a wait
        //ToDo: Should migrate to using POM classes rather than using direct WebDrievr calls
        String searchResultText = driver.findElement(By.cssSelector("#rso div.g")).getText();
        assertThat(searchResultText, containsString(expectedResult));
    }

}
