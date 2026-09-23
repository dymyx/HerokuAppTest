package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends TestBase {
    private DropdownPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new DropdownPage(driver);
        page.open();
    }

    @Test(description = "Получить все элементы дропдауна")
    public void testGetAllDropdownOptions() {
        Assert.assertFalse(page.getOptions().isEmpty(), "Дропдаун должен содержать опции");
        Assert.assertTrue(page.getOptionsCount() >= 3, "Должно быть минимум 3 опции (включая Please select)");
    }

    @Test(description = "Выбрать первый опцион и проверить selection")
    public void testSelectFirstOption() {
        page.selectByIndex(1);

        Assert.assertEquals(page.getSelectedOptionText(), "Option 1");
    }

    @Test(description = "Выбрать второй опцион и проверить selection")
    public void testSelectSecondOption() {
        page.selectByIndex(2);

        Assert.assertEquals(page.getSelectedOptionText(), "Option 2");
    }

    @Test(description = "Выбрать опцион по значению")
    public void testSelectByValue() {
        page.selectByValue("1");

        Assert.assertEquals(page.getSelectedOptionText(), "Option 1");
    }
}