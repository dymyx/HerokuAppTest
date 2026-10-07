package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HoversPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/hovers";
    private static final By USER_AVATARS = By.className("figure");
    private static final By USER_CAPTION = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public List<WebElement> getUserFigures() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(USER_AVATARS));
    }

    public int getUsersCount() {
        return getUserFigures().size();
    }

    public void hoverOnUser(int index) {
        WebElement figure = getUserFigures().get(index);
        new Actions(driver).moveToElement(figure).perform();
    }

    public boolean isUserCaptionVisible(int index) {
        WebElement figure = getUserFigures().get(index);
        WebElement caption = wait.until(
            ExpectedConditions.visibilityOf(figure.findElement(USER_CAPTION))
        );
        return caption.isDisplayed();
    }

    public String getUserCaptionText(int index) {
        return getUserFigures().get(index).findElement(USER_CAPTION).getText();
    }

    public boolean hasAvatar(int index) {
        WebElement figure = getUserFigures().get(index);
        return !figure.findElements(By.tagName("img")).isEmpty();
    }
}