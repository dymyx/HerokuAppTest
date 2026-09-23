package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SortableDataTablesPage;

public class SortableDataTablesTest extends TestBase {
    private SortableDataTablesPage page;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        page = new SortableDataTablesPage(driver);
        page.open();
    }

    @Test(description = "Проверить содержимое первой ячейки таблицы")
    public void testFirstCellContent() {
        String cellText = page.getCellText(1, 1);

        Assert.assertNotNull(cellText, "Текст ячейки не должен быть null");
        Assert.assertFalse(cellText.trim().isEmpty(), "Ячейка должна содержать текст");
    }

    @Test(description = "Проверить содержимое второй ячейки таблицы")
    public void testSecondCellContent() {
        String cellText = page.getCellText(1, 2);

        Assert.assertNotNull(cellText, "Текст ячейки не должен быть null");
        Assert.assertFalse(cellText.trim().isEmpty(), "Ячейка должна содержать текст");
    }

    @Test(description = "Проверить содержимое третьей ячейки таблицы")
    public void testThirdCellContent() {
        String cellText = page.getCellText(1, 3);

        Assert.assertNotNull(cellText, "Текст ячейки не должен быть null");
        Assert.assertFalse(cellText.trim().isEmpty(), "Ячейка должна содержать текст");
    }

    @Test(description = "Проверить что таблица содержит ячейки")
    public void testTableHasCells() {
        Assert.assertFalse(page.getTableCells().isEmpty(), "Таблица должна содержать ячейки");
        Assert.assertTrue(page.getTableCellsCount() >= 3, "Таблица должна содержать минимум 3 ячейки");
    }

    @Test(description = "Проверить что все ячейки имеют текст")
    public void testAllCellsHaveContent() {
        for (WebElement cell : page.getTableCells()) {
            Assert.assertFalse(cell.getText().trim().isEmpty(), "Каждая ячейка должна содержать текст");
        }
    }
}