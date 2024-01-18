package tek.bdd.pages;

import org.openqa.selenium.By;

public class GeneralElements {
    public static final By SECTION_TITLE = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class, 'chakra-stack')]/h2");

    public static By getLinkLocator(String linkText) {
        return By.linkText(linkText);
    }
}
