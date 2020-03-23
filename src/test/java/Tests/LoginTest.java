package Tests;

import Pages.LaunchLandingPage;
import Pages.LoginPage;
import Utils.Config;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Utils.ListenersTestng.class)

public class LoginTest extends Config {

    LaunchLandingPage landingPage;
    LoginPage login;


    @Test
    public void testSuccessLogin() {
        landingPage = new LaunchLandingPage(driver);
        landingPage.verifyLaunchLandingPage();
        login = new LoginPage(driver);
        landingPage.navigateToSignInScreen();
        login.enterCredentials("mobiletest750@gmail.com","DaddyMummy20*");
        login.success();
    }

    @Test
    public void failureLogin() {
        landingPage = new LaunchLandingPage(driver);
        login = new LoginPage(driver);
        landingPage.verifyLaunchLandingPage();
        landingPage.navigateToSignInScreen();
        login.enterCredentials("test@test.com", "qwerty");
        login.verifyErrorMessage();
    }
}
