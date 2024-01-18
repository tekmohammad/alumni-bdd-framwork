package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tek.bdd.base.BaseSetup;

public class CucumberHooks extends BaseSetup {

    @Before
    public void initializeTest() {
        initializeFramework();
    }

    @After
    public void cleanUpTests() {
        closeBrowser();
    }
}
