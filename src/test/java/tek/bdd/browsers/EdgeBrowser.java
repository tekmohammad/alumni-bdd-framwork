package tek.bdd.browsers;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser implements IBrowser{


    @Override
    public WebDriver setupBrowser(boolean isHeadless) {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) options.addArguments("--headless");
        return new EdgeDriver(options);
    }
}
