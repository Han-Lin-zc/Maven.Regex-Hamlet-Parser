import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public void changeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher m = pattern.matcher(hamletData);
        hamletData = m.replaceAll("Leon");
    }

    public void changeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Tariq");
    }

    public boolean findHamlet() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.find();
    }

    public boolean findHoratio() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.find();
    }


    public String getHamletData() {
        return hamletData;
    }

}
