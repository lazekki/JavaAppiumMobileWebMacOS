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
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@id='ca-watch'][contains (@title, 'Watch')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://*[@id='ca-watch'][contains (@title, 'Remove this page from your watchlist')]";

        OPTIONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVE = "xpath://*[@id='ca-watch'][contains (@title, 'Add this page to your watchlist')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON_BEFORE_REMOVE = "xpath://*[@id='ca-watch'][contains (@title, 'Unwatch')]";


    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
