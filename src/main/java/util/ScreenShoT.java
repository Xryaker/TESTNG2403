package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShoT {
    public static void getScreenShot(WebDriver driver, String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("pictures/failures/" + new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + fileName + ".png");
        try {
            FileUtils.copyFile(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getWebElementPNG(WebElement ele, WebDriver driver, String fileName) {   // create PNG

// Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg;
        try {
            fullImg = ImageIO.read(screenshot);
        } catch (IOException e) {
            return;

        }

// Get the location of element on the page
        Point point = ele.getLocation();

// Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        try {
            ImageIO.write(eleScreenshot, "png", screenshot);
        } catch (IOException e) {
            return;
        }

// Copy the element screenshot to disk
        File screenshotLocation = new File("pictures/Success/" + new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + fileName + ".png");

        try {
            FileUtils.copyFile(screenshot, screenshotLocation);
        } catch (IOException e) {
        }

    }
}
