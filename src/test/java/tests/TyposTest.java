package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TyposPage;

public class TyposTest extends TestBase {
    private TyposPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new TyposPage(driver);
        page.open();
    }

    @Test(description = "Проверить содержимое параграфов")
    public void testParagraphsExist() {
        Assert.assertFalse(page.getParagraphs().isEmpty(), "На странице должны быть параграфы");
        Assert.assertTrue(page.getParagraphsCount() > 0, "Должна быть хотя бы одна параграф");
    }

    @Test(description = "Проверить текст содержит ошибку в первой параграфе")
    public void testFirstParagraphContent() {
        String text = page.getParagraphText(0);

        Assert.assertNotNull(text, "Текст параграфа не должен быть null");
        Assert.assertFalse(text.trim().isEmpty(), "Текст параграфа не должен быть пустым");
    }

    @Test(description = "Проверить вторую параграф содержит текст")
    public void testSecondParagraphContent() {
        if (page.getParagraphsCount() > 1) {
            Assert.assertFalse(page.getParagraphText(1).trim().isEmpty(), "Вторая параграф не должна быть пустой");
        }
    }

    @Test(description = "Проверить что параграфы содержат буквы")
    public void testParagraphsContainLetters() {
        for (String text : page.getParagraphTexts()) {
            Assert.assertTrue(text.matches(".*[a-zA-Z].*"),
                "Параграф должна содержать буквы: " + text);
        }
    }
}