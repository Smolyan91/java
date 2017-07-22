package smolyan.java.operation;

import smolyan.java.DataArguments;

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
    public void move(String locatePathFile, String newPathFile) throws IOException {
        Path from = Paths.get(locatePathFile).toRealPath();
        Path to = Paths.get(newPathFile).toRealPath();

    }

    @Override
    public void copy(String originalFile, String targetFile) throws IOException {
        Path from = Paths.get(originalFile).toRealPath();
        Path to = Paths.get(targetFile).toRealPath();

    }

    @Override
    public void search(String pattern, String filePath)throws IOException{
        Path path = Paths.get(filePath).toRealPath();
        try (DirectoryStream<Path>directoryStream = Files.newDirectoryStream(path, "*" + pattern + "*")){
            if (directoryStream != null){
                listMessageSuccess = new LinkedList<>();
                for (Path entry: directoryStream){
                    listMessageSuccess.add(entry.getFileName());
                    System.out.println(entry.getFileName());
                }
            }
        }catch (Exception e){
            listMessageError = new ArrayList<>();
            listMessageError.add(e.getMessage());
        }
    }
}
