package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.CreateAccountElements;
import tek.bdd.utility.FakeData;
import tek.bdd.utility.SeleniumUtilities;

import java.util.Map;

public class CreateAccountSteps extends SeleniumUtilities {

    @When("fill up create account form")
    public void fillUpCreateAccountForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        String firstName = data.get("lastName");
        String lastName = data.get("firstName");
        String email = data.get("email").equals("random") ? FakeData.emailAddress(firstName, lastName) :
                data.get("email");
        //Store email address to recoder map
        recorder.put("email", email);
        recorder.put("fullName", firstName + " " + lastName);
        sendText(CreateAccountElements.EMAIL_INPUT, email);
        sendText(CreateAccountElements.FIRST_NAME_INPUT, firstName);
        sendText(CreateAccountElements.LAST_NAME_INPUT, lastName);
        sendText(CreateAccountElements.EMPLOYMENT_INPUT, data.get("employmentStatus"));
        sendText(CreateAccountElements.DOB_INPUT, data.get("dob"));
        selectFromDropDown(CreateAccountElements.PREFIX_SELECT, data.get("prefix"));
        selectFromDropDown(CreateAccountElements.GENDER_SELECT, data.get("gender"));
        selectFromDropDown(CreateAccountElements.MARITAL_STATUS_SELECT, data.get("maritalStatus"));
    }


    @Then("validate created fullName and email")
    public void validateCreatedFullNameAndEmail() {
        String expectedEmail = recorder.get("email");
        String actualEmail = getElementText(CreateAccountElements.EMAIL_TITLE);
        Assert.assertEquals("Validate created account", expectedEmail, actualEmail);
        String expectedFullName = recorder.get("fullName");
        String actualFullName = getElementText(CreateAccountElements.FULLNAME_TITLE);
        Assert.assertEquals("Validating created account", expectedFullName, actualFullName);
    }
}
