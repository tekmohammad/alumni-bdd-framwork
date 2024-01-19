package tek.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountElements {
    public static final By EMAIL_INPUT = By.name("email");
    public static final By PREFIX_SELECT = By.name("title");
    public static final By FIRST_NAME_INPUT = By.name("firstName");
    public static final By LAST_NAME_INPUT = By.name("lastName");
    public static final By GENDER_SELECT = By.name("gender");
    public static final By MARITAL_STATUS_SELECT = By.name("maritalStatus");
    public static final By EMPLOYMENT_INPUT = By.name("employmentStatus");
    public static final By DOB_INPUT = By.name("dateOfBirth");
    public static final By FULLNAME_TITLE = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class, 'chakra-stack')]/h2[2]");
    public static final By EMAIL_TITLE = By.xpath("//div[@id='root']/div/div[2]//div[contains(@class, 'chakra-stack')]/h2[3]");
}
