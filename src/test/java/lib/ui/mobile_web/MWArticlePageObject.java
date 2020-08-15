package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        /*
        OPTIONS_ADD_TO_MY_LIST_BUTTON_IN_MY_LIST = "xpath://*[@id='content']/div/ul/li/a[contains (@title, 'Add this page to your watchlist')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON_IN_MY_LIST = "xpath://*[@id='content']/div/ul/li/a[contains (@title, 'Remove this page from your watchlist')]";
        */
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:a#ca-watch.mw-ui-icon";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://*[@id='content']/div/nav/ul/li/a[@data-event-name='menu.watch'][@title='Remove this page from your watchlist']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
