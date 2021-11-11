package desktop.pages;

import org.openqa.selenium.By;

import abstractClasses.page.AbstractPage;


public class HomePage extends AbstractPage {
	private static final String homePageUrl = "https://www.bookdepository.com/";
	private static final By searchField = By.xpath("//*[@class='text-input']");

	public void openHomePage(String page) {
		openWebsite(homePageUrl);
	}

	public void getSearchInputField(String product) {
		waitUntilElementClickable(searchField);
		setElementSendKeysEnter(searchField, product);
	}


}
