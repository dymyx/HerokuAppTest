package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputsPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/inputs";
    private static final By INPUT = By.tagName("input");

    public InputsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    private WebElement getInput() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(INPUT));
    }

    public void enterValue(String value) {
        WebElement input = getInput();
        input.click();
        input.clear();
        input.sendKeys(value);
    }

    public void pressKey(Keys key) {
        getInput().sendKeys(key);
    }

    public String getValue() {
        return getInput().getAttribute("value");
    }
}