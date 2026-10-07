package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class TyposPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/typos";
    private static final By PARAGRAPHS = By.tagName("p");

    public TyposPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public List<WebElement> getParagraphs() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(PARAGRAPHS));
    }

    public int getParagraphsCount() {
        return getParagraphs().size();
    }

    public String getParagraphText(int index) {
        return getParagraphs().get(index).getText();
    }

    public List<String> getParagraphTexts() {
        List<String> texts = new ArrayList<>();
        for (WebElement paragraph : getParagraphs()) {
            texts.add(paragraph.getText());
        }
        return texts;
    }
}