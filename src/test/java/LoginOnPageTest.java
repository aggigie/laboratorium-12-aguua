
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginOnPageTest {
    private static WebDriver driver;
    private String testLogin = "aga.test.selenium@gmail.com";

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testLoginGithub() throws Exception {
        String githubLoginUrl = "https://github.com/login";
        LoginOnFactory gitHubLogin = new LoginOnFactory(driver, githubLoginUrl);
        gitHubLogin.logIn(testLogin, "selenium_passwd");
        assertTrue(gitHubLogin.assertTitleContains("GitHub"));
    }

    @Test
    @Disabled
    public void testLoginOnet() throws Exception {
        String onetLoginUrl = "https://www.onet.pl/poczta";
        LoginOnFactory onetLogin = new LoginOnFactory(driver, onetLoginUrl);
        onetLogin.logIn(testLogin, "selenium1Passwd");  // zablokowane konto
        assertTrue(onetLogin.assertTitleContains("Szukaj w Onet.pl"));
    }


        // "https://www.x-kom.pl/logowanie";  //inny przycisk..


    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }

}
