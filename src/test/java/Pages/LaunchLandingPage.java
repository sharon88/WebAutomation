package Pages;

import Utils.Helpers;
import Utils.ProjectAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchLandingPage {

    WebDriver driver;
    Helpers helpers;
    ProjectAssertions assertions;


    public LaunchLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helpers = new Helpers(driver);
        assertions = new ProjectAssertions();
    }

    @FindBy(id = "home-welcome")
    WebElement WELCOME_TEXT_ID;
    @FindBy(id = "download")
    WebElement GET_WORDPRESS_BUTTON;
    @FindBy(css = "h1.entry-title")
    WebElement GET_WORDPRESS_PAGE;
    @FindBy(id = "wp-admin-bar-log-in")
    WebElement LOGIN_BUTTON;



    public void verifyLaunchLandingPage() {
        Boolean isWelcomeTextDisplayed = helpers.elementExists(WELCOME_TEXT_ID);
        assertions.assertTrue(isWelcomeTextDisplayed);
    }

    public void navigateToSignInScreen() {
        GET_WORDPRESS_BUTTON.click();
        assertions.assertTrue(helpers.elementExists(GET_WORDPRESS_PAGE));
        LOGIN_BUTTON.click();
    }

}
