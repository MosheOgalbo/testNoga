package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public   class  DriverDefinition {
    public static WebDriver Drver(String url){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(url);
        return driver;
    }
    public static void switchBetweenScreens(WebDriver driver){
        String mainWindow=driver.getWindowHandle();
//        System.out.println(mainWindow);
        Set<String> s1 = driver .getWindowHandles();
        Iterator<String> driverUrl =s1.iterator();

        while (driverUrl.hasNext()){
            String childWindow =driverUrl.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                System.out.println("The driver moves to the screen: "+driver.getTitle());
                driver.switchTo().window(mainWindow).close();
                driver.switchTo().window(childWindow);
            }
        }
    }
}
