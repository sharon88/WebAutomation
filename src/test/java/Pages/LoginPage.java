package Pages;

import Utils.Helpers;
import Utils.ProjectAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    ProjectAssertions assertions;
    Helpers helpers;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        assertions = new ProjectAssertions();
        helpers = new Helpers(driver);
    }

    @FindBy(id = "user_login")
    WebElement LOGIN_EDIT_TEXT;
    @FindBy(id = "user_pass")
    WebElement PASSWORD_EDIT_TEXT;
    @FindBy(id = "wp-submit")
    WebElement SUBMIT_BUTTON;
    @FindBy(id = "login_error")
    WebElement LOGIN_ERROR;
    @FindBy(id = "wp-admin-bar-my-account")
    WebElement LOGIN_SUCCESS;


    public void enterCredentials(String username, String password) {
        LOGIN_EDIT_TEXT.sendKeys(username);
        PASSWORD_EDIT_TEXT.sendKeys(password);
        SUBMIT_BUTTON.click();
    }

    public void verifyErrorMessage() {
        assertions.assertTrue(helpers.elementExists(LOGIN_ERROR));
    }

    public void success() {
        helpers.waitForElement(LOGIN_SUCCESS);
    }


}
