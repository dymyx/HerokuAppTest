package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/add_remove_elements/";
    private static final By ADD_BUTTON = By.xpath("//button[text()='Add Element']");
    private static final By DELETE_BUTTONS = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_BUTTON)).click();
    }

    public void clickAddButton(int times) {
        for (int i = 0; i < times; i++) {
            clickAddButton();
        }
    }

    public void clickDeleteButton(int index) {
        List<WebElement> deleteButtons = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(DELETE_BUTTONS)
        );
        deleteButtons.get(index).click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(DELETE_BUTTONS).size();
    }

    public void waitForDeleteButtonsCount(int expectedCount) {
        wait.until(ExpectedConditions.numberOfElementsToBe(DELETE_BUTTONS, expectedCount));
    }
}