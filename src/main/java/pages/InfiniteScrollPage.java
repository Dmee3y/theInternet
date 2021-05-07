package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;

   private By textBlock = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    //index starts from 1
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        while (getParagraphsCount() < index) {
            javascriptExecutor.executeScript(script);
        }
    }

    public int getParagraphsCount() {
        return driver.findElements(textBlock).size();
    }
}
