package smolyan.java;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by igor on 23.07.17.
 */
public class RecursiveSearch extends SimpleFileVisitor<Path>{

    private List<Path> pathList;
    private String pattern;

    public RecursiveSearch(String pattern) {
        pathList = new LinkedList<>();
        this.pattern = pattern;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().contains(pattern)){
            this.pathList.add(file.toRealPath());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPathList() {
        return this.pathList;
    }
}
