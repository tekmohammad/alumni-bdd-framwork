package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FirefoxBrowser;
import tek.bdd.browsers.IBrowser;
import tek.bdd.exception.FrameworkSetupException;
import tek.bdd.utility.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class BaseSetup {
    private static WebDriver driver;

    public static Map<String, String> recorder = new HashMap<>();

    public WebDriver getDriver() {
        return driver;
    }

    private final Properties properties;

    //Setup Framework
    //Setup browser
    //navigate to application.
    public BaseSetup() {
        //Custom property that can set by Maven or By OS Environment variable.
        //Values we pass to tek_env will be dev or qa
        // Maven goal will be something like mvn clean test -Dtek_env=qa
        String targetEnvironment = System.getProperty("tek_env");
        String configFilePath;
        if (targetEnvironment == null) {
            configFilePath = Constants.CONFIG_FILE_BASE_PATH + "dev_env.properties";
        } else {
            configFilePath = Constants.CONFIG_FILE_BASE_PATH + targetEnvironment + "_env.properties";
        }
        System.out.println("Config file path ::::: " + configFilePath);
        this.properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(configFilePath);
            this.properties.load(inputStream);
        } catch (IOException ex) {
            throw new FrameworkSetupException("Can not load property file with message " + ex.getMessage());
        }
    }

    public String getProperty(String key) {
        return this.properties.get(key).toString();
    }

    public void initializeFramework() {
        //browser type
        //url for environment.
        String browser = getProperty("browser.type");
        boolean isHeadless = Boolean.parseBoolean(getProperty("browser.isHeadless"));
        IBrowser browserInterface;
        switch (browser.toLowerCase()) {
            case "chrome":
                browserInterface = new ChromeBrowser();
                break;
            case "firefox":
                browserInterface = new FirefoxBrowser();
                break;
            case "edge":
                browserInterface = new EdgeBrowser();
                break;
            default:
                throw new FrameworkSetupException("Wrong Browser type");
        }
        driver = browserInterface.setupBrowser(isHeadless);
        //Selenium configuration.
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.get(getProperty("base_url"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
