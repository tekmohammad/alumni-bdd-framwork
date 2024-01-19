package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.GeneralElements;
import tek.bdd.utility.CommonUtilities;
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
    @Then("validate card title to be {string}")
    public void validateCardTitle(String expectedTitle) {
        String actualTitle = getElementText(GeneralElements.CARD_TITLE);
        Assert.assertEquals("Section Title" , expectedTitle, actualTitle);
    }
    @When("click on {string} button")
    public void clickOnButton(String buttonText) throws InterruptedException {
        clickOnElement(GeneralElements.getButtonLocator(buttonText));
        CommonUtilities.waitTime(500);
    }

    @When("send text {string} to {string} field")
    public void sendTextToField(String text, String field) throws InterruptedException {
        if (text.equalsIgnoreCase("random")) {
            String email = recorder.get("email");
            text = email.substring(0, email.indexOf("@"));
        }
        sendText(GeneralElements.getInputLocator(field), text);
    }

    @Given("wait {int} second")
    public void waitSecond(int seconds) {
        CommonUtilities.waitTime(seconds * 1000);
    }

    @Then("validate application title {string}")
    public void validateApplicationTitle(String expectedTitle) {
      String actualTitle = getElementText(GeneralElements.APPLICATION_TITLE);
      Assert.assertEquals("Validate application title", expectedTitle, actualTitle);
    }
}
