@Regression
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the "Initial home page"
    And I search for "1934793"
    And I am redirected to a "Search page"
    And click 'Add to cart' button for product with code "1934793"
    And I select 'Check Out' in cart pop-up
    And I am redirected to a "Cart page"
    And I can view order summary
      | Subtotal | Total  |
      | $99.85   | $99.85 |
    And I click 'Checkout' button after redirect to cart page
    And I checkout as guest user with email "test@user.com"
    And I am redirected to a "Multicheckout delivery address page"
    And I have the following final review
      | Subtotal | Total   | Tax   |
      | $99.85   | $99.85  | $4.75 |
    And I fill in delivery address information
      | Country       | Title | First Name | Last Name | Address Line 1  | City      | Region       | Post Code  |
      | United States | Mr.   | John       | Doe       | 16 Sandy Palace | Honesdale | Pennsylvania | 18431-0000 |
    When I press 'Next' button on delivery address page
    And I am redirected to a "Multicheckout delivery method page"
    And I have the following final review
      | Subtotal | Delivery | Tax   | Total   |
      | $99.85   | $11.99   | $5.33 | $111.84 |
    And I select "Standard Delivery - 3-5 business days - $11.99" delivery method
    And I press 'Next' button on delivery method page
    And I am redirected to a "Multicheckout delivery payment page"
    And I have the following final review
      | Subtotal | Delivery  | Tax   | Total   |
      | $99.85   | $11.99    | $5.33 | $111.84 |
    And I select to use my delivery address
    And I enter my card details
      | Card Type     | Visa             |
      | Name On Card  | RandomName       |
      | cardNumber    | 4111111111111111 |
      | Expiry Year   | 2022             |
      | Expiry Month  | 03               |
      | Cvv           | 123              |
    And I press 'Next' button on payment method page
    And I agree with terms and conditions
    #If you use different from demolab site, then the following steps should not be implemented
    And I press 'Place order' button
    Then I am redirected to a "Checkout confirmation page"
    And I have the following final review at order confirmation page
      | Subtotal | Delivery  | Tax   | Total   |
      | $99.85   | $11.99    | $5.33 | $111.84 |
    And checkout confirmation message is "Thank you for your Order!"
    And I can obtain an order number
    And I press 'Continue shopping' button on checkout confirmation page
    And I am redirected to a "Search page"
    And mini cart icon on header shows "0" items in cart