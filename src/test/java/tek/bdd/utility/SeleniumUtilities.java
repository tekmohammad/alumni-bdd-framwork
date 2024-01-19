package tek.bdd.utility;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtilities extends BaseSetup {

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }

    public WebElement waitTillVisibility(By locator) {
       return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator) {
        return waitTillVisibility(locator).getText();
    }

    public void sendText(By locator , String text) {
        waitTillVisibility(locator).sendKeys(text);
    }

    public void selectFromDropDown(By locator, String visibleText) {
       WebElement element = waitTillVisibility(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropDown(By locator, int index) {
        WebElement element = waitTillVisibility(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public List<WebElement> getElements(By locator) {
      return  getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
