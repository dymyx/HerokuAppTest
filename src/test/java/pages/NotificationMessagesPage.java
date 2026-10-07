package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NotificationMessagesPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/notification_message";
    private static final By NOTIFICATION_LINK = By.linkText("Click here");
    private static final By NOTIFICATION_MESSAGE = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public void clickNotificationLink() {
        wait.until(ExpectedConditions.elementToBeClickable(NOTIFICATION_LINK)).click();
    }

    public WebElement getNotification() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_MESSAGE));
    }

    public String getNotificationText() {
        return getNotification().getText();
    }

    public boolean isNotificationDisplayed() {
        List<WebElement> notifications = driver.findElements(NOTIFICATION_MESSAGE);
        return !notifications.isEmpty() && notifications.get(0).isDisplayed();
    }

    public void closeNotification() {
        WebElement notification = getNotification();
        WebElement closeButton = notification.findElement(
            By.xpath(".//*[contains(@class, 'close') or contains(@class, 'dismiss')]")
        );
        if (closeButton != null) {
            closeButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(NOTIFICATION_MESSAGE));
        }
    }
}