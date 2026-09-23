package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SortableDataTablesPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/tables";
    private static final By TABLE_CELLS = By.xpath("//table//tr//td");

    public SortableDataTablesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public List<WebElement> getTableCells() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(TABLE_CELLS));
    }

    public int getTableCellsCount() {
        return getTableCells().size();
    }

    public String getCellText(int row, int column) {
        By cellLocator = By.xpath("//table//tr[" + row + "]//td[" + column + "]");
        return wait.until(ExpectedConditions.presenceOfElementLocated(cellLocator)).getText();
    }
}