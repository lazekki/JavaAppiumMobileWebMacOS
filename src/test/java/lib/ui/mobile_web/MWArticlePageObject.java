package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        //"#ca-watch"
        //"<a id="ca-watch"
        // href="/w/index.php?title=Special:UserLogin&amp;returnto=Java+%28programming+language%29"
        // class="mw-ui-icon mw-ui-icon-element mw-ui-icon-wikimedia-star-base20 mw-ui-icon-with-label-desktop watch-this-article mw-watchlink menu__item--page-actions-watch"
        // data-mw="interface"
        // data-event-name="menu.watch" role="button" title="Watch">Watch</a>"
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
        /*
        * 09.08.2020 from Web Inspector:
        * css: #ca-watch
        * xpath: //*[@id="ca-watch"]
        * HTML:
        * Watched (to unwatch): <a id="ca-watch" href="/w/index.php?title=McCann&amp;action=unwatch" class="mw-ui-icon mw-ui-icon-element mw-ui-icon-with-label-desktop watch-this-article mw-watchlink menu__item--page-actions-watch mw-ui-icon-wikimedia-unStar-progressive watched" data-mw="interface" data-event-name="menu.unwatch" role="button" title="Remove this page from your watchlist">Unwatch</a>
        * Not watched (to watch): <a id="ca-watch" href="/w/index.php?title=McCann&amp;action=watch"   class="mw-ui-icon mw-ui-icon-element mw-ui-icon-with-label-desktop watch-this-article mw-watchlink menu__item--page-actions-watch mw-ui-icon-wikimedia-star-base20" data-mw="interface" data-event-name="menu.unwatch" role="button" title="Add this page to your watchlist">Watch</a>
        */


    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
