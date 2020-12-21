package utils;

import static utils.DriverFactory.getDriver;
import static utils.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {


    @Before
    public void onSetUp(){
        getDriver();
    }

    @After
    public void onTearDown(Scenario scenario){
        try {
            TakesScreenshot ss = (TakesScreenshot) getDriver();
            File arquivo = ss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                    File.separator + scenario.getId() + ".jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }

        killDriver();
    }

}
