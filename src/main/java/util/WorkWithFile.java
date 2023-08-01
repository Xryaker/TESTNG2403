package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class WorkWithFile {
    public static void writeStrings(List<String> list,String fileName){
        String data=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file= new File("src/main/java/logs/"+data+"_"+fileName+".txt");
        FileWriter writer=null;
        try {
            writer=new FileWriter(file);
            for (String l : list) {
                writer.write(l+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(String filename){
        File file= new File(filename);
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader("src/main/java/logs/"+file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  br.lines().toList();
    }
}
