package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {
    private AddRemoveElementsPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new AddRemoveElementsPage(driver);
        page.open();
    }

    @Test(description = "Добавить 2 элемента")
    public void testAddTwoElements() {
        page.clickAddButton(2);
        page.waitForDeleteButtonsCount(2);

        Assert.assertEquals(page.getDeleteButtonsCount(), 2, "Должно быть 2 DELETE кнопки");
    }

    @Test(description = "Удалить элемент")
    public void testRemoveElement() {
        page.clickAddButton(2);
        page.waitForDeleteButtonsCount(2);
        Assert.assertEquals(page.getDeleteButtonsCount(), 2);

        page.clickDeleteButton(0);
        page.waitForDeleteButtonsCount(1);

        Assert.assertEquals(page.getDeleteButtonsCount(), 1, "Должна остаться 1 DELETE кнопка");
    }

    @Test(description = "Проверить количество DELETE кнопок после добавления 3 элементов")
    public void testThreeElementsCount() {
        page.clickAddButton(3);
        page.waitForDeleteButtonsCount(3);

        Assert.assertEquals(page.getDeleteButtonsCount(), 3, "Должно быть 3 DELETE кнопки");
    }
}