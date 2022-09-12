import Pages.CustomFunctions;
import Pages.OperationsElement;
import Pages.TestMainPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Tests {
    public  static  Boolean task1(WebDriver driver){
      try {

          OperationsElement.clicklOnLogo(driver);
          WebElement Summary = driver.findElement(TestMainPageElements.Summary);
          if(CustomFunctions.stringComparon(Data.companySummary,Summary.getText()) &&
                  CustomFunctions.stringComparon(Data.url,driver.getCurrentUrl())){
              return true;

          }else {return false;}

      }catch (Exception e){
          System.out.println(e);
          return false;
      }
    };

    public  static  Boolean task2(WebDriver driver){
        try {
            String [] arrayElement=new String[3];
            Pages.OperationsElement.bottomOfScreen(driver);
            List<WebElement> footerIcons =driver.findElements(By.className("footer-icons-block-item"));
            System.out.println(footerIcons.size());

//            System.out.println(footerIcons.get(0).findElement(By.className("icon-block-title")).getText());
           for (int i = 0; arrayElement.length > i; i++) {
               arrayElement[i] = footerIcons.get(i).findElement(By.className("icon-block-title")).getText();
               System.out.println(arrayElement[i]);
           }

            return  true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public  static  boolean task3(WebDriver driver) throws InterruptedException {
        OperationsElement.bottomOfScreen(driver);
        OperationsElement.clickOnIconExpost(driver);
        Pages.DriverDefinition.switchBetweenScreens(driver);
        Thread.sleep(100);
        WebElement expostPriceList = driver.findElement(By.tagName("h2"));
        System.out.println(expostPriceList.getText());
        if(expostPriceList.getText().equals(StringTest.testStringExpost)){
            OperationsElement.clicklOnLogo(driver);
            return true;
        }else {
            OperationsElement.clicklOnLogo(driver);
            return false;
        }
    }

    public static boolean task4(WebDriver driver, WebDriverWait wait)throws InterruptedException{
        OperationsElement.bottomOfScreen(driver);
        OperationsElement.clickOnIconExpost(driver);
        Pages.DriverDefinition.switchBetweenScreens(driver);
        OperationsElement.bottomOfScreen(driver);
        WebElement initialDateField = driver.findElement(By.id("startDate"));
        WebElement endDateField=driver.findElement(By.id("endDate"));
        WebElement showDataButton =driver.findElement(By.id("get-table-button"));

        // תאריך של היום
        String dateInStringNow= CustomFunctions.dateNow();
      // תאריך של שבוע שעבר
        String yesterdayDate= CustomFunctions.oldDate();

        endDateField.clear();
        endDateField.sendKeys(yesterdayDate);
        initialDateField.sendKeys(dateInStringNow);
        showDataButton.click();
        OperationsElement.waitInvisibilityOfPreloader(driver,wait);
        String numberData = endDateField.getAttribute("value");

        if (numberData.equals(dateInStringNow)) {
            OperationsElement.clicklOnLogo(driver);
           return true;
        }
        else {
        System.out.println("error");
        OperationsElement.clicklOnLogo(driver);
        return false;
        }

    }

    public  static  void task5(WebDriver driver, WebDriverWait wait) throws Exception {
        OperationsElement.bottomOfScreen(driver);
        OperationsElement.clickOnIconExpost(driver);
        Pages.DriverDefinition.switchBetweenScreens(driver);
        OperationsElement.bottomOfScreen(driver);
        WebElement initialDateField = driver.findElement(By.id("startDate"));
        WebElement endDateField=driver.findElement(By.id("endDate"));
        WebElement showDataButton =driver.findElement(By.id("get-table-button"));
// תאריך של היום
        String dateInStringNow= CustomFunctions.dateNow();
// תאריך של שבוע שעבר
       String yesterdayDate= CustomFunctions.oldDate();

        endDateField.clear();
        endDateField.sendKeys(dateInStringNow);
        initialDateField.sendKeys(yesterdayDate);
        showDataButton.click();
        OperationsElement.waitInvisibilityOfPreloader(driver,wait);
        WebElement linkExel= driver.findElement(By.className("download-link"));
        linkExel.click();
        System.out.println(GetExcel.Excel());


    }

}
