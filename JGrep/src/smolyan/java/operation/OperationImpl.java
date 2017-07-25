package smolyan.java.operation;

import smolyan.java.DataArguments;
import smolyan.java.PrintInfo;
import smolyan.java.RecursiveSearch;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//TODO реализовать логику работы с флагами
public class OperationImpl implements Operation{

    private DataArguments dataArguments;
    private List<Path> pathList;
    private static Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw-");
    private static FileAttribute<Set<PosixFilePermission>> attribute = PosixFilePermissions.asFileAttribute(permissions);

    public OperationImpl(DataArguments dataArguments) {
        this.dataArguments = dataArguments;
    }

    public void start() throws IOException{
        if (this.dataArguments != null){
            switch (dataArguments.getCommandDA()){
                case GREP:
                    this.grep(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case CP  :
                    this.copy(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case MV  :
                    this.move(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case SRCH:
                    this.search(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case RM  :
                    this.remove(this.dataArguments.getMassArgs()[0]);
                    break;
                case RENAME:
                    this.rename(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case CRF:
                    this.createFile(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case CRD:
                    createDirectory(this.dataArguments.getMassArgs()[0], this.dataArguments.getMassArgs()[1]);
                    break;
                case INFO:
                    infoFile(this.dataArguments.getMassArgs()[0]);
                    break;
                case SET_PROPS:
                    updateProps(this.dataArguments.getMassArgs()[1], this.dataArguments.getMassArgs()[0]);
                    break;
                default:break;
            }
        }else System.out.println("DataArguments is null!!!");//TODO исследовать
    }

    @Override
    public void updateProps(String pattern, String path) throws IOException {
        Path toRealPath = Paths.get(path).toRealPath();
        PosixFileAttributes attributes =
                Files.readAttributes(toRealPath, PosixFileAttributes.class);
        Set<PosixFilePermission> permissions = attributes.permissions();
        permissions.clear();
        String owner = attributes.owner().getName();
        String perm = PosixFilePermissions.toString(permissions);
        System.out.format("%s %s%n",owner, perm);
        permissions.add(PosixFilePermission.OWNER_READ);
        permissions.add(PosixFilePermission.OWNER_WRITE);
        permissions.add(PosixFilePermission.OWNER_EXECUTE);
        if (owner.equalsIgnoreCase("root"))
            permissions.add(PosixFilePermission.OWNER_EXECUTE);
        if (pattern.contains("-")){
            String[] attrMass = pattern.split("-");
            if (attrMass.length >= 2){
                char[] user = attrMass[1].toCharArray();
                for (int i = 0; i < user.length; i++) {
                    if (user[i] == 'r') permissions.add(PosixFilePermission.OTHERS_READ);
                    if (user[i] == 'w') permissions.add(PosixFilePermission.OTHERS_WRITE);
                    if (user[i] == 'x')
                        if(attributes.owner().toString().equalsIgnoreCase("root")
                            || toRealPath.toAbsolutePath().toString().contains("/home/igor")){
                        permissions.add(PosixFilePermission.OTHERS_EXECUTE);
                    }
                }
            }
            if (attrMass.length == 3){
                char[] group = attrMass[1].toCharArray();
                for (int i = 0; i < group.length; i++) {
                    if (group[i] == 'r') permissions.add(PosixFilePermission.GROUP_READ);
                    if (group[i] == 'w') permissions.add(PosixFilePermission.GROUP_WRITE);
                    if (group[i] == 'x')
                        if (attributes.owner().toString().equalsIgnoreCase("root")
                            || toRealPath.toAbsolutePath().toString().contains("/home/igor")){
                        permissions.add(PosixFilePermission.GROUP_EXECUTE);
                    }
                }
            }
        }
        Files.setPosixFilePermissions(toRealPath, permissions);
        String own = attributes.owner().getName();
        String perms = PosixFilePermissions.toString(permissions);
        PrintInfo.printMessage("File attributes", own + "" + perms);
    }

    /***
     * Создает файл с указанным именем, или несколько файлов, если установлен флаг на создание определенного
     * количества файлов
     * @param fileName
     * @param path
     * @throws IOException
     */
    @Override
    public void createFile(String fileName, String path) throws IOException {
        //TODO заглушка на флаги(кол -во файлов, которые можно будет создать
        String prefixName = fileName.substring(0, fileName.indexOf("."));
        String suffixName = fileName.substring(fileName.indexOf("."));
        int count = 3; //TODO заглушка
        for (int i = 0; i < count; i++) {
            String newFileName = path + "/" + prefixName + i + suffixName;
            Path path1 = Files.createFile(Paths.get(newFileName),attribute);
            System.out.println(path1.getFileName() + " " + path1.toRealPath());
        }
    }

    /***
     * Создает директорию с указанным именем, или несколько директорий, если установлен флаг на создание определенного
     * количества директорий
     * @param dirName
     * @param path
     * @throws IOException
     */
    @Override
    public void createDirectory(String dirName, String path) throws IOException {
        //TODO заглушка на флаги(кол -во файлов, которые можно будет создать
        int count = 3;//TODO заглушка на кол-во созданных директорий
        for (int i = 0; i < count; i++) {
            String newDirName = path + "/" + dirName  + i;
            Path path1 = Files.createDirectory(Paths.get(newDirName), attribute);
            System.out.println(path1.getFileName() + " " + path1.toRealPath());
        }
    }

    @Override
    public void infoFile(String path) throws IOException {
        Path pathToFile = Paths.get(path).toRealPath();
        System.out.println(pathToFile.toRealPath());
        PrintInfo.printInfoAboutFile(pathToFile);
    }

    public static void printFile(Path path) throws  IOException{
        Files.lines(path.toRealPath(), StandardCharsets.UTF_8).forEach(System.out::println);
    }

    //TODO Реализовать флаги
    /***
     * Поиск вхождений в файле по заданному паттерну
     * Находит и заменяет на <*pattern*>. После выхода из режима поиска (q)-
     * возвращает файл к прежнему виду
     * @param pattern
     * @param pathToFile
     * @param replacePattern
     * @throws IOException
     */
    @Override
    public void grep(String pattern, String pathToFile, String ...replacePattern) throws IOException {
        Path path = Paths.get(pathToFile).toRealPath();
        Charset charset = StandardCharsets.UTF_8;
        String boldText = "<*" + pattern + "*>";
        if (replacePattern.length > 0){
            Files.write(path,
                    new String(Files.readAllBytes(path),charset)
                            .replaceAll(pattern, replacePattern[0])
                            .getBytes());
            printFile(path);
            return;
        }
        Files.write(path,
                new String(Files.readAllBytes(path),charset)
                        .replaceAll(pattern, boldText)
                        .getBytes());
        printFile(path);
        try(Scanner scanner = new Scanner(System.in)){
            String exit;
            do{
                exit = scanner.next();
            }while (!exit.equalsIgnoreCase("q"));
        }
        Files.write(path,
                new String(Files.readAllBytes(path),charset)
                        .replace(boldText, pattern)
                        .getBytes());
        //Очистка консоли
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("clear");
        printFile(path);
    }

    @Override
    public void remove(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile).toRealPath();
        Files.deleteIfExists(path);
    }

    @Override
    public void move(String source, String target) throws IOException {
        Path from = Paths.get(source).toRealPath();
        Path to = Paths.get(target).toRealPath();
        Files.move(from, to,
                StandardCopyOption.ATOMIC_MOVE,
                StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING);
    }

    /***
     * -r : replace - скопирует файл и перезапишет, если такой файл уже существует
     * @param source
     * @param targetFile
     * @throws IOException
     */
    @Override
    public void copy(String source, String targetFile) throws IOException {
        Path from = Paths.get(source).toRealPath();
        Path to = Paths.get(targetFile).toRealPath();
        //TODO реализовать с флагами
        Files.copy(from, to,
                StandardCopyOption.ATOMIC_MOVE,
                StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING);
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

    @Override
    public void rename(String newName, String path) throws IOException {

    }
}
