import Pages.DriverDefinition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainTest {

    public static void main(String[] args) throws Exception {
          WebDriver driver = DriverDefinition.Drver(Data.url);
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//          Thread.sleep(100);
           ///1
          System.out.println(Tests.task1(driver));
          ///2

         System.out.println(Tests.task2(driver));

        ///3
        System.out.println(Tests.task3(driver));


        // 4
        System.out.println(Tests.task4(driver,wait));

        // 5
        Tests.task5(driver,wait);
//driver.close();
    };
};
