package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        //OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        //OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:a[data-event-name='menu.watch']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:a#ca-watch.mw-ui-icon";
        //OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:a[data-event-name='menu.unwatch']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
