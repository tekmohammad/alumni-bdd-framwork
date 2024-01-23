package tek.bdd.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements IBrowser{

    @Override
    public WebDriver setupBrowser(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
