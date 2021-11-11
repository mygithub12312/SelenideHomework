package stepDefs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.codeborne.selenide.junit5.ScreenShooterExtension;

import desktop.pages.*;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;

@ExtendWith({ ScreenShooterExtension.class})
public class DesktopCheckoutForGuestUser {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("selenide/screenshots");

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    BasketPage basketPage = new BasketPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnAnonymousCustomerWithClearCookies() {
    }

    @When("I open the {string}")
    public void iOpenThe(String arg0) {
        homePage.openHomePage();
    }

    @And("I search for {string}")
    public void iSearchFor(String product) {
        homePage.getSearchInputField(product);
    }

    @And("I am redirected to a {string} page")
    public void iAmRedirectedToA(String page) {
        assertThat(searchResultsPage.getSearchResultPageUrl())
              .as("Redirect to Search Page").containsIgnoringCase(page);
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(List<String> expectedProducts) {
        assertThat(searchResultsPage.getSearchResultsByXpath())
              .as("Results do not contain expected products")
              .containsAnyElementsOf(expectedProducts);
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(Map<String, String> filters) {
        searchResultsPage.selectFilters(filters);
    }

    @Then("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedBooks) {
        assertThat(searchResultsPage.getSearchResultsByXpath())
              .as("Expected book is not displayed")
              .isEqualTo(expectedBooks);
    }

    @When("I click Add to Basket button for product with name Thinking in Java")
    public void iClickAddToBasketButtonForProductWithName() {
        searchResultsPage.getAddToCartButton();
    }

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp(String button) {
        searchResultsPage.getBasketButton(button);
    }

    @Then("I am redirected to the {string}")
    public void iAmRedirectedToThe(String page) {
        assertThat(basketPage.getPageUrl())
              .as("Basket page is not displayed")
              .containsIgnoringCase(page);
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(@Transpose Map<String, String> expectedTotals) {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(basketPage.getDeliveryPrice())
              .overridingErrorMessage("Delivery cost does not equal to expected value")
              .isEqualTo(expectedTotals.get(basketPage.getDeliveryTitle()));

        softly.assertThat(basketPage.getBasketTotal())
              .overridingErrorMessage("Order total does not equal to expected value")
              .isEqualTo(expectedTotals.get(basketPage.getTotalPriceTitle()));
    }

    @When("I click {string} button on {string} page")
    public void iClickCheckoutButtonOnBasketPage(String button, String page) {
        basketPage.getCheckoutButton(button, page);
    }

    @Then("I am redirected to the {string} page")
    public void iAmRedirectedToThePage(String page) {
        assertThat(checkoutPage.getCheckoutPageUrl()).containsIgnoringCase(page);
    }

    @When("I click {string} button")
    public void iClickBuyNowButton() {
    }

    @Then("the following validation error messages are displayed on {string} form:")
    public void theFollowingValidationErrorMessagesAreDisplayedOnDeliveryAddressForm() {
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing() {
    }

    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String arg0) {
    }

    @When("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually() {
    }

    @Then("there is no validation error messages displayed on {string} form")
    public void thereIsNoValidationErrorMessagesDisplayedOnDeliveryAddressForm() {
    }

    @When("I enter my card details")
    public void iEnterMyCardDetails() {
    }
}
