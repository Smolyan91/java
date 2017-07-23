package smolyan.java.operation;

import smolyan.java.DataArguments;
import smolyan.java.RecursiveSearch;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class OperationImpl implements Operation{

    private DataArguments dataArguments;
    private List<Path> pathList;
    private List<Path> listMessageSuccess;
    private List<String> listMessageError;

    public OperationImpl(DataArguments dataArguments) {
        this.dataArguments = dataArguments;
    }

    public void start()
            throws IOException{
        if (this.dataArguments != null){
            switch (dataArguments.getCommandDA()){
                case GREP: this.grep(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);break;
                case CP  : this.copy(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);break;
                case MV  : this.move(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);break;
                case SRCH: this.search(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);break;
                case RM  : this.remove(this.dataArguments.getMassArgs()[0]);break;
                default:break;
            }
        }else System.out.println("DataArguments is null!!!");//TODO исследовать
    }

    @Override
    public void grep(String pattern, String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile).toRealPath();


    }

    @Override
    public void remove(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile).toRealPath();

    }

    @Override
    public void move(String source, String target) throws IOException {
        Path from = Paths.get(source).toRealPath();
        Path to = Paths.get(target).toRealPath();

    }

    @Override
    public void copy(String source, String targetFile) throws IOException {
        Path from = Paths.get(source).toRealPath();
        Path to = Paths.get(targetFile).toRealPath();

    }

    /***
     * Рекурсивный поиск по дереву каталогов относительно переданного пути path
     * по заданному шаблону (pattern)
     * Возвращает коллекцию с найденными файлами
     * @param pattern
     * @param filePath
     * @throws IOException
     */
    @Override
    public void search(String pattern, String filePath)throws IOException{
        Path path = Paths.get(filePath).toRealPath();
        RecursiveSearch recursiveSearch = new RecursiveSearch(pattern);
        Files.walkFileTree(path, recursiveSearch);
        pathList = recursiveSearch.getPathList();
        for (Path entry: this.pathList){
            //TODO вывести в менеджер
            //TODO обработать AccessDenied Exception  при доступе к файлу
            System.out.println("Name: " + entry.getFileName() + "\tAbsolute path: " + entry.toRealPath());
        }
    }
}
