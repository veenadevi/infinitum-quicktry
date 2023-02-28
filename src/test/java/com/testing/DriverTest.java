package com.testing;

import com.google.inject.Inject;
import com.qualitrix.infinitum.annotation.Author;
import com.qualitrix.infinitum.data.DataReader;
import com.qualitrix.infinitum.data.DataReaderService;
import com.qualitrix.infinitum.data.DataReaderServiceLocator;
import com.qualitrix.infinitum.data.excel.ExcelSpreadsheetFormat;
import com.qualitrix.infinitum.device.driver.AutoConfigurableWebDriverService;
import com.qualitrix.infinitum.inject.InjectorModule;
import com.qualitrix.infinitum.logging.Logger;
import com.qualitrix.infinitum.logging.LoggingService;
import com.qualitrix.infinitum.notification.NotificationService;
import com.qualitrix.infinitum.notification.Notifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Author(name = "Qualitrix")
@Guice(modules = InjectorModule.class)
public class DriverTest {
    @Inject
    private LoggingService loggingService;

    private Logger logger;

    @Inject
    private AutoConfigurableWebDriverService driverService;


    @Inject
    private NotificationService  notification;
    private Notifier notifier;




    private WebDriver driver;

    @Test
    public void CheckDriver() {

        notifier = notification.getNotifier();
        notifier.notify("starting from infitium");
        //WebDriverManager.chromedriver().setup();
         driver = driverService.getDriver();
        driver = new ChromeDriver();
        driver.get("https://qualitrix.com/");
        System.out.println(driver.getTitle());
        logger = loggingService.getLogger(getClass());
        logger.info("driver launched" + driver.getClass());


    }

    @Test
    public void checkExcelReader() {
        DataReaderService service = DataReaderServiceLocator.getInstance().getDataReaderService(ExcelSpreadsheetFormat.XLSX);



        // Find a reader for reading XLS data.

        DataReader reader = service.getDataReader(ExcelSpreadsheetFormat.XLS);
        //reader.read()
    }
}
