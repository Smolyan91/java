package smolyan.java.operation;


import java.io.IOException;

public interface Operation {
    void grep(String pattern, String pathToFile, String ...replacePattern) throws IOException;
    void remove(String pathToFile) throws IOException;
    void move(String locatePathFile, String newPathFile) throws IOException;
    void copy(String originalFile, String targetFile) throws IOException;
    void search(String pattern, String filePath) throws IOException;
    void rename(String newName, String path) throws IOException;
    void createFile(String fileName, String path) throws IOException;
    void createDirectory(String dirName, String path) throws IOException;
    void infoFile(String path) throws IOException;
    void updateProps(String pattern, String path) throws IOException;
}
