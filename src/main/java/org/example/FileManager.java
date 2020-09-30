package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    private FileManager() {
    }

    public static void saveTextToFile(List<String> branches, String filePath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
            for (String branch : branches) {
                bw.append(branch).append("\r\n").append("\r\n").flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
