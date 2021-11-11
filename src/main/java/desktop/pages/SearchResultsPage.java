package desktop.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import abstractClasses.page.AbstractPage;


public class SearchResultsPage extends AbstractPage {

	final String pageUrl = "https://www.bookdepository.com/search";
	final By productTitles = By.xpath("//*[@class='title']");
	final By priceFilter = By.xpath("//*[@name='price']");
	final By availabilityFilter = By.xpath("//*[@name='availability']");
	final By languageFilter = By.xpath("//*[@name='searchLang']");
	final By formatFilter = By.xpath("//*[@name='format']");
	final By addToCartButton = By.xpath("//*[@data-isbn='9780131872486']");
	final By basketButton = By.xpath("//*[@class='btn btn-primary pull-right continue-to-basket string-to-localize link-to-localize']");

	private static final By applyFilters = By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div/form/div[6]/button");

	final String price = "Price range";
	final String availability = "Availability";
	final String language = "Language";
	final String format = "Format";

	public String getSearchResultPageUrl() {
		return pageUrl;
	}

	public List<String> getSearchResultsByXpath() {
		waitUntilElementVisible(productTitles);
		return getResults(productTitles);
	}

	public void getAddToCartButton() {
		waitUntilElementClickable(addToCartButton);
		clickElement(addToCartButton);
	}

	public void getBasketButton(String button) {
		waitUntilElementClickable(basketButton);
		clickElement(basketButton);
	}

	public void setPriceFilter (String priceRefinementFilter) {
		setElementByVisibleText(priceFilter,priceRefinementFilter);
	}

	public void setAvailabilityFilter (String availabilityRefinementFilter) {
		setElementByVisibleText(availabilityFilter,availabilityRefinementFilter);
	}

	public void setLanguageFilter (String languageRefinementSelector) {
		setElementByVisibleText(languageFilter,languageRefinementSelector);
	}

	public void setFormatFilter (String formatRefinementSelector) {
		setElementByVisibleText(formatFilter,formatRefinementSelector);
	}

	public void setApplyFilters() {
		jsScrollByPixels("0", "100");
		findElement(applyFilters).click();
	}


	public void selectFilters (Map<String, String> filters) {
		setPriceFilter(filters.get(price));
		setAvailabilityFilter(filters.get(availability));
		setLanguageFilter(filters.get(language));
		setFormatFilter(filters.get(format));
		setApplyFilters();
	}
}
