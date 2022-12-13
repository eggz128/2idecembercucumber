package uk.co.edgewords;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private WebDriver driver;

    private SharedDictionary myDict;

    public Hooks(SharedDictionary myDict) {
        this.myDict = myDict;
    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Put the driver in to the shared dictionary for use in other classes
        myDict.addDict("mydriver",driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
