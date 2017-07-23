package smolyan.java;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by igor on 23.07.17.
 */
public class SingleDirectoryLocation {

    private List<Path> pathList;
    private Path path;
    private String pattern;

    public SingleDirectoryLocation(Path path, String pattern) {
        this.path = path;
        this.pattern = pattern;
        pathList = new LinkedList<>();
        this.searchFiles();
    }

    private void searchFiles() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(this.path, this.pattern)){

            if (directoryStream != null){
                for (Path entry: directoryStream){
                    this.pathList.add(entry.toRealPath());
                }
            }
        }catch (Exception e){
            e.getStackTrace();
            e.getMessage();
        }
    }

    public List<Path> getPathList() {
        return pathList;
    }
}
