package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/dropdown";
    private static final By DROPDOWN = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    private Select getDropdown() {
        return new Select(wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN)));
    }

    public List<WebElement> getOptions() {
        return getDropdown().getOptions();
    }

    public int getOptionsCount() {
        return getOptions().size();
    }

    public void selectByIndex(int index) {
        getDropdown().selectByIndex(index);
    }

    public void selectByValue(String value) {
        getDropdown().selectByValue(value);
    }

    public String getSelectedOptionText() {
        return getDropdown().getFirstSelectedOption().getText();
    }
}