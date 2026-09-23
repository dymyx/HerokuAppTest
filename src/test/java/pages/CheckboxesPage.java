package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckboxesPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";
    private static final By CHECKBOXES = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    private List<WebElement> getCheckboxes() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CHECKBOXES));
    }

    public boolean isCheckboxSelected(int index) {
        return getCheckboxes().get(index).isSelected();
    }

    public void check(int index) {
        WebElement checkbox = getCheckboxes().get(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(int index) {
        WebElement checkbox = getCheckboxes().get(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}