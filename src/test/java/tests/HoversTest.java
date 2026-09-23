package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoversTest extends TestBase {
    private HoversPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new HoversPage(driver);
        page.open();
    }

    @Test(description = "Hover на первый профиль и проверить появление информации")
    public void testHoverFirstUser() {
        page.hoverOnUser(0);

        Assert.assertTrue(page.isUserCaptionVisible(0), "Информация о пользователе должна быть видна");
        Assert.assertFalse(page.getUserCaptionText(0).trim().isEmpty(), "Подпись должна содержать текст");
    }

    @Test(description = "Hover на второй профиль и проверить появление информации")
    public void testHoverSecondUser() {
        if (page.getUsersCount() > 1) {
            page.hoverOnUser(1);

            Assert.assertTrue(page.isUserCaptionVisible(1), "Информация о пользователе должна быть видна");
        }
    }

    @Test(description = "Hover на третий профиль и проверить появление информации")
    public void testHoverThirdUser() {
        if (page.getUsersCount() > 2) {
            page.hoverOnUser(2);

            Assert.assertTrue(page.isUserCaptionVisible(2), "Информация о пользователе должна быть видна");
        }
    }

    @Test(description = "Проверить что все профили содержат аватары")
    public void testAllProfilesHaveAvatars() {
        Assert.assertFalse(page.getUserFigures().isEmpty(), "На странице должны быть профили");
        Assert.assertTrue(page.getUsersCount() >= 3, "Должно быть минимум 3 профиля");

        for (int i = 0; i < page.getUsersCount(); i++) {
            Assert.assertTrue(page.hasAvatar(i), "Профиль должен содержать аватар");
        }
    }
}