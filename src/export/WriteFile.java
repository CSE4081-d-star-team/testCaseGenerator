package src.export;

import java.awt.Desktop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    File file;

    public void writeToFile (String content, String filePath) {
        file = new File(filePath);

        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            FileWriter fw = new FileWriter(file, false); //false - new, true - append 
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        Desktop desktop = Desktop.getDesktop();  
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }  
    }
}
