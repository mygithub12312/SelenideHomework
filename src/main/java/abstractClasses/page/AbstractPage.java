package abstractClasses.page;

import static com.codeborne.selenide.Selenide.*;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import com.codeborne.selenide.*;


public abstract class AbstractPage {

    private String pageUrl;
    private String pageUrlPattern;

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public SelenideElement findElement(By by) {
        return $(by).should(Condition.exist);
    }

    public ElementsCollection findElements(By by) {
        return $$(by).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public void jsScrollByPixels(String pixelsUp, String pixelsDown) {
        Selenide.executeJavaScript("window.scrollBy(arguments[0], arguments[1])", pixelsUp, pixelsDown);
    }

    public void clickElement(By by) {
        findElement(by).click();
    }

    public void setElementSendKeys(By by, String value) {
        findElement(by).setValue(value);
    }

    public void setElementSendKeysEnter(By by, String value) {
        findElement(by).setValue(value).pressEnter();
    }

    public void setElementByVisibleText(By by, String value) {
        findElement(by).selectOptionContainingText(value);
    }

    public String getElementText(By by) {
        return findElement(by).getText();
    }

    public List<String> getResults(By by) {
        return findElements(by).stream().map(SelenideElement::getText).collect(Collectors.toList());
    }

    public void findElementByDynamicXpathAndClick(String xpath, String value) {
        findElement(By.xpath(String.format(xpath, value))).click();
    }

    public void openWebsite(String pageUrl) {
        open(pageUrl);
    }

    public void waitUntilElementClickable(By locator) {
        $(locator).should(Condition.appear);
    }

    public void waitUntilElementVisible(By locator) {
        $(locator).should(Condition.visible);
    }
}
