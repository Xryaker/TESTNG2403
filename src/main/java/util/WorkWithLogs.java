package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkWithLogs {

    public static void printLogs(WebDriver driver){
        LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry l : logEntries) {
            System.out.println(l.toString());
        }
    }

    public static void writeLogs(WebDriver driver, String filename){
        LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);
        String data=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file= new File("src/main/java/logs/"+data+"_"+filename+".txt");
        FileWriter writer=null;
        try {
            writer=new FileWriter(file);
            for (LogEntry l : logEntries) {
                writer.write(l.toString()+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
