package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {

    static {
        //ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@id='mw-content-text']/ul/li/a[@class='title']/h3[contains(text(),'{TITLE}')]";
        //REMOVED_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://*[@id='content']/div/ul/li[contains (@title, '{TITLE}')]/a[contains (@class,'watched')]";
        }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
