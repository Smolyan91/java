package smolyan.java.operation;

import smolyan.java.DataArguments;

import java.io.IOException;
import java.nio.file.Path;

public class OperationImpl implements Operation{

    private DataArguments dataArguments;

    public OperationImpl(DataArguments dataArguments) {
        this.dataArguments = dataArguments;
    }

    public void start()
            throws IOException{
        if (this.dataArguments != null){
            switch (dataArguments.getCommandDA()){
                case GREP: this.grep(this.dataArguments.getMassArgs()[1], this.dataArguments.getMassArgs()[2]);break;
                case CP  : this.copy(this.dataArguments.getMassArgs()[1], this.dataArguments.getMassArgs()[2]);break;
                case MV  : this.move(this.dataArguments.getMassArgs()[1], this.dataArguments.getMassArgs()[2]);break;
                case RM  : this.remove(this.dataArguments.getMassArgs()[1]);break;
                default:break;
            }
        }else System.out.println("DataArguments is null!!!");//TODO исследовать
    }

    @Override
    public void grep(String pattern, String pathToFile) throws IOException {

    }

    @Override
    public void remove(String pathToFile) throws IOException {

    }

    @Override
    public void move(String locatePathFile, String newPathFile) throws IOException {

    }

    @Override
    public void copy(String originalFile, String targetFile) throws IOException {

    }
}
