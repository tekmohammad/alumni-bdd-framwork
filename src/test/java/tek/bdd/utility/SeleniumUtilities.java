package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }

    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

    }
}
