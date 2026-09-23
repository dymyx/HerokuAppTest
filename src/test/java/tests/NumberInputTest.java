package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InputsPage;

public class NumberInputTest extends TestBase {
    private InputsPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new InputsPage(driver);
        page.open();
    }

    @Test(description = "Ввести цифровые значения")
    public void testEnterNumericValues() {
        page.enterValue("123");

        Assert.assertEquals(page.getValue(), "123", "Значение должно быть 123");
    }

    @Test(description = "Ввести нецифровые значения")
    public void testEnterNonNumericValues() {
        page.enterValue("abc");

        String value = page.getValue();
        Assert.assertTrue(value.isEmpty() || value.matches("\\d*"),
            "Number input должен отклонить нецифровые значения");
    }

    @Test(description = "Использовать Keys.ARROW_UP для увеличения значения")
    public void testArrowUpKey() {
        page.enterValue("5");

        for (int i = 0; i < 3; i++) {
            page.pressKey(Keys.ARROW_UP);
        }

        int value = Integer.parseInt(page.getValue());
        Assert.assertTrue(value >= 5, "Значение должно быть увеличено");
    }

    @Test(description = "Использовать Keys.ARROW_DOWN для уменьшения значения")
    public void testArrowDownKey() {
        page.enterValue("10");

        for (int i = 0; i < 3; i++) {
            page.pressKey(Keys.ARROW_DOWN);
        }

        int value = Integer.parseInt(page.getValue());
        Assert.assertTrue(value <= 10, "Значение должно быть уменьшено");
    }
}