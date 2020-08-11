package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
        OPTION_TO_SAVE_WITHOUT_AUTH = "css:a[data-event-name='menu.watch']",
        //LOGIN_BUTTON = "xpath://body/div/a[text()='Log in']",
        LOGIN_BUTTON = "css:a.mw-ui-button.mw-ui-progressive",
        LOGIN_INPUT = "css:input[name='wpName']",
        PASSWORD_INPUT = "css:input[name='wpPassword']",
        SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        this.waitForElementAndClick(OPTION_TO_SAVE_WITHOUT_AUTH, "Cannot call auth menu", 10);
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 10);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 5);
    }

    public void enterLoginData(String login, String password) {
        this.waitForElementAndSendKeys(
                LOGIN_INPUT, login,
                "Cannot find and put a login to the login input",
                5);

        this.waitForElementAndSendKeys(
                PASSWORD_INPUT, password,
                "Cannot find and put a password to the password input",
                5);
    }

    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 5);
    }

}
