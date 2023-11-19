package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ContactsXpathTest {

    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","MiA2");
        config.setCapability("platformVersion","10.0");
        config.setCapability("appPackage","com.google.android.contacts");
        config.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        // implicit / explicit / fluent
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
    @Test
    public void verifyCreateContactTest() throws InterruptedException {
        String nametask = "AAPROYECTO";
        // click +
        mobile.findElement(By.id("com.google.android.contacts:id/floating_action_button")).click();
        // click nombre
        mobile.findElement(By.xpath("//android.widget.EditText[@text='Nombre']")).sendKeys("AAPROYECTO");
        // click apellido
        mobile.findElement(By.xpath("//android.widget.EditText[@text='Apellido']")).sendKeys("UCB");
        // click en  numero empresa
        mobile.findElement(By.xpath("//android.widget.EditText[@text='Empresa']")).sendKeys("60129607");
        // click guardar
        mobile.findElement(By.id("com.google.android.contacts:id/toolbar_button")).click();

        Thread.sleep(5000);
        // verificacion  expected vs actual
        Assertions.assertTrue(mobile.findElements(By.id("com.google.android.contacts:id/large_title")).size() ==1,
                "ERROR NO EXISTE CONTACTO");

    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}