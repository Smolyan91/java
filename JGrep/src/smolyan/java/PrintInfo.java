package smolyan.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by igor on 25.07.17.
 */
public class PrintInfo {

    public static void printInfoAboutFile(Path path){
        try {
            System.out.println("File name: " + path.getFileName());
            System.out.println("Size: " + Files.size(path));
            if (Files.isDirectory(path)) System.out.println("This file is directory");
            else if (Files.isSymbolicLink(path)) System.out.println("This file is symbolic link");
            else System.out.println("This is file");
            System.out.println("Attributes: " + Files.readAttributes(path, "*"));
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
