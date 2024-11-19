package ProfilePage;

import PageFactory.Header;
import PageFactory.LoginPage;
import PageFactory.HomePage;
import PageFactory.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ProfileTests extends TestObject {
    @DataProvider(name = "getUsers")
    
    public Object[][] getUsers() {
        return new Object[][]{
                {"TestMail_5@gmail.com", "LucyVasileva1", "LucyVasileva"},
        };
    }

    @Test(dataProvider = "getUsers")
    public void testLogin(String email, String password, String name) {
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        HomePage homePage = new HomePage(super.getDriver());
        homePage.navigateTo();

        Header header = new Header(super.getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(super.getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded());

        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");

        loginPage.populateUserName(email);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        Assert.assertTrue(homePage.isUrlLoaded());
        header.clickProfile();

        ProfilePage profilePage = new ProfilePage(super.getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");

        String actualUserName = profilePage.getUserName();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");
    }
}