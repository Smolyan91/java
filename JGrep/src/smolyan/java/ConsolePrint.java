/**
 * Created by igor on 02.09.17.
 */
public class ConsolePrint {

    public static void printInfo(String ...info){

        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
            System.out.println();
        }
    }
}
