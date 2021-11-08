package src.file;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportFile {
    
    File file;

    public boolean fileExist(String filePath) {
        file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void toString(char[][] map) {
        if (map == null) {
            System.out.println("Map is empty");
            return;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void openFile(String filePath) {
        file = new File(filePath);
        Desktop desktop = Desktop.getDesktop();  
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }  
    }

    public char[][] readFile (String filePath) {
        file = new File(filePath);
        char[][] map = null;
        if(fileExist(filePath)) {
            try {
                FileReader fw = new FileReader(file);
                BufferedReader bw = new BufferedReader(fw);
                ArrayList<String> arrList = new ArrayList<String>();
                //count row first
                String line = bw.readLine();
                while (line != null) {
                    arrList.add(line);
                    line = bw.readLine();
                }

                map = new char[arrList.size()][arrList.size()];
                
                //remove space between cells
                bw = new BufferedReader(fw);
                for (int i = 0; i < arrList.size(); i++) {
                    line = arrList.get(i);
                    int column = 0;
                    for (int j = 0; j < line.length(); j ++) {
                        if (j % 2 == 0) {
                            map[i][column] = line.charAt(j);
                            column++;
                        }
                    }
                    line = bw.readLine();
                }
                bw.close();

            } catch (IOException ex) {
                System.out.println(ex);
            }
            toString(map);
            return map;
        } else {
            System.out.println("No file");
            return null;
        }
    }
}
