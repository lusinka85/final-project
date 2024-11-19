package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/post/all"; //константа, която не искаме да се промени
    private final WebDriver driver; // деклариране на driver като class variable в HomePage

    public HomePage(WebDriver driver) { //Подаване на стойност в конструктора
        this.driver = driver;
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void navigateTo(){
        driver.get(PAGE_URL);
    }
}
