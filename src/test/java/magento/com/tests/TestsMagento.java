package magento.com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestsMagento extends BaseTest {


    @DataProvider(name = "Shipping info")
    public Object[][] shippingInfoData() {
        return new Object[][]{
                {"george@mail.com", "George", "Landsberg", "Amazon", "Address1", "Miami", "Florida", 33101, "United States", 134563231, "Password1", "Password1"}

        };
    }


    @Test(dataProvider = "Shipping info")
    public void createAccountTest(String email, String name, String lastName, String company, String address, String city,
                                  String state, int code, String country, int phone, String password, String confirmPass) {
        createAnAccount.clickCreateAccountLink();
        Assert.assertEquals(createAnAccount.getPageHeader(), "Create New Customer Account");
        Assert.assertEquals(createAnAccount.getHeaderTitle(), "Personal Information");
        createAnAccount.enterFirstName(name);
        createAnAccount.enterLastName(lastName);
        createAnAccount.clickSignUpForNewsletter();
        Assert.assertEquals(createAnAccount.getSignInHeader(), "Sign-in Information");
        createAnAccount.enterEmail(email);
        createAnAccount.enterPassword(password);
        createAnAccount.enterConfirmPassword(confirmPass);
        createAnAccount.clickCreateAccountBtn();
        Assert.assertEquals(createAnAccount.getMyAccountHeader(), "My Account");
        Assert.assertEquals(createAnAccount.getAccountInfo(), "Account Information");
        Assert.assertEquals(createAnAccount.getContactInfo(), "Contact Information");
        Assert.assertEquals(createAnAccount.getFullNameAndEmail(), name + ' ' + lastName + "\n" + email);

        //Adding Several Products
        addProducts.selectCategory(4);
        addProducts.clickShirts();
        //Adding product I got your back T-shirt
        addProducts.addToCartProducts1(0);
        addProducts.enterQuantity(3);
        addProducts.clickAddToCartBtn();

        //Adding T-shirt Funny T shirt
        addProducts.addToCartProducts1(1);
        addProducts.enterQuantity(2);
        addProducts.clickAddToCartBtn();

        //Adding Maica Mashka Plava
        addProducts.addToCartProducts1(2);
        addProducts.selectDropDown("S");
        addProducts.enterQuantity(3);
        addProducts.clickAddToCartBtn();

        //Scrolling to the shopping cart
        shoppingCart.clickCartBtn();
        shoppingCart.clickDeleteButton();
        shoppingCart.confirmingDeleteProduct();
        shoppingCart.clickCheckOutButton();

        //Entering shipping details
        shippingAddress.enterCompany(company);
        shippingAddress.enterStreetAddress(address);
        shippingAddress.enterCity(city);
        shippingAddress.selectState(state);
        shippingAddress.enterZipCode(code);
        shippingAddress.selectCountry(country);
        shippingAddress.enterNumber(phone);
        shippingAddress.clickNextBtn();

        //Checkout
        Assert.assertEquals(payment.getStepTitle(), "Payment Method");
        Assert.assertEquals(payment.getBillingItemsDetails(), name + ' ' + lastName +
                "\n" + address + "\n" + city + ", " + state + ' ' + code + "\n" + country + "\n" + phone);
        payment.clickPlaceOrderBtn();

        sleep(3000);


    }


    private void sleep(long m) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
