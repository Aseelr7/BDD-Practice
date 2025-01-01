package utilities;

import config.ConfigManager;
import enums.WaitStrat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static enums.WaitStrat.CLICKABLE;

public class WaitUtils {


    public static Duration getTimeout(){
        String timeoutValue = ConfigManager.getProperty("timeout");
        int timeoutInSeconds = (timeoutValue != null) ? Integer.parseInt(timeoutValue) : 10;
        return Duration.ofSeconds(timeoutInSeconds);
    }

    public static void applyGlobalWait(){
        boolean enableWait = Boolean.parseBoolean( ConfigManager.getProperty("EnableWait") );
        int timeoutInSeconds = Integer.parseInt(ConfigManager.getProperty("waitInSeconds"));
        System.out.println("Is wait enabled : " + enableWait);
        System.out.println("TimeOut in seconds : " + timeoutInSeconds);

        if (enableWait && timeoutInSeconds > 0 ){
            try{
                Thread.sleep(timeoutInSeconds * 1000L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Global Wait Interrupted. " + e.getMessage());
            }
        }
    }

    public static WebElement applyWait(WebDriver driver , WebElement webElement, WaitStrat waitStrategy){
        WebDriverWait wait = new WebDriverWait(driver, getTimeout());

        switch (waitStrategy){
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(webElement));

            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOf(webElement));

            case NONE:
            default:
                return webElement;

        }
    }

    public static WebElement applyWait(WebDriver driver , WebElement webElement, WaitStrat waitStrategy, By element){
        WebDriverWait wait = new WebDriverWait(driver, getTimeout());

        switch (waitStrategy){
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(webElement));

            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(element));

            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOf(webElement));

            case NONE:
            default:
                return webElement;

        }


    }
    public static WebElement waitForPresence(WebDriver driver, By element){

        WebDriverWait wait = new WebDriverWait(driver,getTimeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
