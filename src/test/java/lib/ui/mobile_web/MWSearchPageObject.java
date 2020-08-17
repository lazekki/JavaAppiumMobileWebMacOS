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
        SEARCH_RESULT_ELEMENT = "css:li.page-summary.with-watchstar";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        ARTICLE_TITLE_XPATH = "xpath://*[@id='content']/div/div[@class='page-heading']/h1[@id='section_0']";
        ARTICLE_TITLE_XPATH_IN_MY_LIST = "//*[@id='content']/div/ul/li/a/h3";
        MW_ARTICLE_SEARCH_FIRST_TITLE_XPATH="xpath://*[@id='content']/div/div[@class='page-heading']/h1[@id='section_0'][contains (text(),'Java (programming language)')]";
        MW_ARTICLE_SEARCH_SECOND_TITLE_XPATH="xpath://*[@id='content']/div/div[@class='page-heading']/h1[@id='section_0'][contains (text(),'Java (software platform)')]";

        //TO DO for Mobile Web tests

        /*

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