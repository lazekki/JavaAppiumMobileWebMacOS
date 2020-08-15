package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {

    static {
        //ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@id='mw-content-text']/ul/li/a[@class='title']/h3['{TITLE}']";
        //REMOVED_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
        REMOVED_FROM_SAVED_BUTTON = "xpath://*[@id='mw-content-text']/ul/li[@title='{TITLE}']/a[contains (@class,'mw-ui-icon')]";
        }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
