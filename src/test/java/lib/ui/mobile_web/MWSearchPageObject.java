package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_INPUT_ID = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:.header-action button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";

        //TO DO for Mobile Web tests
        /*
        ARTICLE_SEARCH_FIRST_TITLE_XPATH = "xpath://XCUIElementTypeOther[contains(@name, 'Java (programming language)')]";
        ARTICLE_SEARCH_SECOND_TITLE_XPATH = "xpath://XCUIElementTypeOther[contains(@name, 'Java (software platform)')]";
        ARTICLE_TITLE_XPATH = "xpath://*[@name='Java (software platform)']";
        ARTICLE_IN_SAVED_LIST_TITLE_XPATH = "xpath://XCUIElementTypeLink[contains(@name, 'Java (software platform) Set of several computer software products and specifications')]";
        FIRST_ARTICLE_TITLE_XPATH = "xpath://*[@name='Java (programming language)']";
        SEARCH_RESULT_ARTICLE_ITEM_CONTAINER_TPL =
            "xpath://XCUIElementTypeLink[contains(@name, '{TITLE_SUBSTRING}') or contains (@name, '{DESCRIPTION_SUBSTRING}')]";
        */
}

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}