package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {
    private CheckboxesPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new CheckboxesPage(driver);
        page.open();
    }

    @Test(description = "Проверить, что первый чекбокс unchecked")
    public void testFirstCheckboxUnchecked() {
        Assert.assertFalse(page.isCheckboxSelected(0), "Первый чекбокс должен быть unchecked");
    }

    @Test(description = "Отметить первый чекбокс и проверить checked")
    public void testCheckFirstCheckbox() {
        page.check(0);

        Assert.assertTrue(page.isCheckboxSelected(0), "Первый чекбокс должен быть checked");
    }

    @Test(description = "Проверить, что второй чекбокс checked")
    public void testSecondCheckboxChecked() {
        Assert.assertTrue(page.isCheckboxSelected(1), "Второй чекбокс должен быть checked");
    }

    @Test(description = "Unchecked второй чекбокс и проверить unchecked")
    public void testUncheckSecondCheckbox() {
        page.uncheck(1);

        Assert.assertFalse(page.isCheckboxSelected(1), "Второй чекбокс должен быть unchecked");
    }
}