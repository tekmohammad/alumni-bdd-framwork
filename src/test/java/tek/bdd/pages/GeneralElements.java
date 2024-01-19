package tek.bdd.pages;

import org.openqa.selenium.By;

public class GeneralElements {
    public static final By SECTION_TITLE = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class, 'chakra-stack')]/h2[1]");
    public static final By CARD_TITLE = By.xpath("//div[@id='root']//div[3]//div[contains(@class, 'chakra-stack')]/h2[1]");
    public static final By APPLICATION_TITLE = By.xpath("//div[@id='root']/div/div/div[1]/h2");
    public static By getLinkLocator(String linkText) {
        return By.linkText(linkText);
    }

    public static By getButtonLocator(String buttonText) {
        return By.xpath("//button[text() = '" + buttonText + "']");
    }

    public static By getInputLocator(String field) {
        return By.xpath("//label[text() = '" + field + "']/..//input");
    }
}
