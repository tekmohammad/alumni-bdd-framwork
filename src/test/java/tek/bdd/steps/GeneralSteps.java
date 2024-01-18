package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.GeneralElements;
import tek.bdd.utility.SeleniumUtilities;

public class GeneralSteps extends SeleniumUtilities {

    @Given("landed in home page")
    public void landed_in_home_page() throws InterruptedException {
        Thread.sleep(5000);
    }

    @When("click on {string} link")
    public void clickOnLinks(String linkText) {
        clickOnElement(GeneralElements.getLinkLocator(linkText));
    }

    @Then("validate section title to be {string}")
    public void validateSectionTitle(String expectedTitle) {
       String actualTitle = getElementText(GeneralElements.SECTION_TITLE);
        Assert.assertEquals("Section Title" , expectedTitle, actualTitle);
    }
}
