package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagesPage;

public class NotificationMessagesTest extends TestBase {
    private NotificationMessagesPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new NotificationMessagesPage(driver);
        page.open();
    }

    @Test(description = "Клик на кнопку и проверить появление нотификации")
    public void testNotificationAppears() {
        page.clickNotificationLink();

        Assert.assertTrue(page.getNotification().isDisplayed(), "Нотификация должна быть видна");
    }

    @Test(description = "Проверить текст сообщения нотификации")
    public void testNotificationMessageText() {
        page.clickNotificationLink();

        String notificationText = page.getNotificationText();
        Assert.assertFalse(notificationText.trim().isEmpty(), "Сообщение нотификации не должно быть пустым");
        Assert.assertTrue(notificationText.contains("Action"), "Сообщение должно содержать информацию об действии");
    }

    @Test(description = "Проверить что нотификация содержит успешное сообщение")
    public void testNotificationSuccess() {
        page.clickNotificationLink();

        String notificationText = page.getNotificationText().toLowerCase();
        Assert.assertTrue(
            notificationText.contains("action") || notificationText.contains("successful") || notificationText.contains("message"),
            "Нотификация должна содержать информацию о результате"
        );
    }

    @Test(description = "Проверить что нотификация может быть закрыта")
    public void testNotificationCanBeClosed() {
        page.clickNotificationLink();
        Assert.assertTrue(page.isNotificationDisplayed(), "Нотификация должна быть видна");

        page.closeNotification();
        Assert.assertFalse(page.isNotificationDisplayed(), "Нотификация должна быть закрыта");
    }
}