package desktop.pages;

import org.openqa.selenium.By;

import abstractClasses.page.AbstractPage;


public class BasketPage extends AbstractPage {

	private String pageUrl = "https://www.bookdepository.com/basket";

	private static final By checkoutButton = By.xpath("//div[@class='basketHeaderButtons']//a[contains(@class,'checkout-btn btn')]");

	private static final By basketDeliveryPrice = By.xpath("//*[@class='delivery-text']/dd");
	private static final String basketPriceMap = "Delivery cost";

	private static final By basketTotalPrice = By.xpath("//*[@class='total']/dd");
	private static final String basketTotalMap = "Total";

	public String getPageUrl() {
		return pageUrl;
	}

	public void getCheckoutButton(String button, String pageUrl) {
		waitUntilElementClickable(checkoutButton);
		clickElement(checkoutButton);

	}

	public String getDeliveryPrice() {
		return getElementText(basketDeliveryPrice);
	}

	public String getBasketTotal(){
		return getElementText(basketTotalPrice);
	}

	public String getDeliveryTitle(){
		return basketPriceMap;
	}

	public String getTotalPriceTitle(){
		return basketTotalMap;
	}
}
