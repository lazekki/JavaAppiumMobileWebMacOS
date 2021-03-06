package lib.ui;

import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
        TITLE,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        IOS_MY_LIST_OVERLAY_CLOSE_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVE,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON_BEFORE_REMOVE,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                TITLE,
                "Cannot find article title on page!",
                20
        );
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public void swipeToFooter() {

        String error_message = "Cannot find the end of article";
        int max_swipes = 100;  //for slow workstations 40 is too less

        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, error_message, max_swipes
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, error_message, max_swipes);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT, error_message, max_swipes);
        }
    }

    public void addArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open More article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button to save an article name to reading list",
                5
        );
    }

    public void addArticlesToMySaved() throws InterruptedException {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
            Thread.sleep(1000);
        }

        if(this.isElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "1 Cannot find option to add article to reading list",
                    5
            );
        } else if (this.isElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVE)){
            this.waitForElementAndClick(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVE,
                    "2 Cannot find option to add article to reading list",
                    5
            );
        }
    }

    public void removeArticleFromSavedIfItAdded() {

        if (Platform.getInstance().isMw()) {
            if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON_BEFORE_REMOVE)) {
                this.waitForElementAndClick(
                        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON_BEFORE_REMOVE,
                        "Cannot click button to remove article from saved",
                        5
                );

                this.waitForElementPresent(
                        OPTIONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVE,
                        "Cannot find button to add an article to saved list after removing it from this list before",
                        5
                );
            }
        } else {
            if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
                this.waitForElementAndClick(
                        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                        "Cannot click button to remove article from saved",
                        5
                );

                this.waitForElementPresent(
                        OPTIONS_ADD_TO_MY_LIST_BUTTON,
                        "Cannot find button to add an article to saved list after removing it from this list before",
                        5
                );
            }
        }


    }

    public void closeOverlayIfSaveArticleFirstTime() {
        this.waitForElementAndClick(IOS_MY_LIST_OVERLAY_CLOSE_BUTTON,
                "Cannot find button to close overlay over of my lists",
                30);
    }

    public void closeArticle() {

        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {

            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }
}
