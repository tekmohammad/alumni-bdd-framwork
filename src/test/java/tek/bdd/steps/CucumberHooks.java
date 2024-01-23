package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.base.BaseSetup;
import tek.bdd.utility.SeleniumUtilities;

public class CucumberHooks extends SeleniumUtilities {

    @Before
    public void initializeTest() {
        initializeFramework();
    }

    @After
    public void cleanUpTests(Scenario scenario) {
        //Clear Out recorder after each test
        if (scenario.isFailed()) {
          byte[] screenShot =  takeScreenShot();
          scenario.attach(screenShot, "image/png" , "screenshot");
        }
        recorder.clear();
        closeBrowser();
    }
}
