package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.*;

public class OperationsElement {

public static void click (WebElement element){ element.click();}
public static void typing (WebElement element , String text ){
        element.sendKeys(text);
    }
public  static  void  bottomOfScreen (WebDriver driver){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
public static  void clicklOnLogo(WebDriver driver){
    WebElement logo = driver.findElement(TestMainPageElements.byLogo);
    OperationsElement.click(logo);
}
public static void clickOnIconExpost(WebDriver driver){
    List<WebElement> footerIcons = driver.findElements(By.className("footer-icons-block-item"));
    footerIcons.get(0).findElement(By.tagName("a")).click();
}
public static  void waitInvisibilityOfPreloader(WebDriver driver,WebDriverWait wait) throws InterruptedException {
    sleep(1000);
    WebElement preloader =driver.findElement(By.id("preloader"));
    wait.until(ExpectedConditions.invisibilityOf(preloader));
}

}
