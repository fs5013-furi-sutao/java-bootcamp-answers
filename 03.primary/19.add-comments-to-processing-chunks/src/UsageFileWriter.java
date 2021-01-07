import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UsageFileWriter {

    static final Path DIR_PATH = Paths.get("C:\\tmp");
    static final Path FILE_PATH = Paths.get("C:\\tmp\\test.txt");
    static final String QUOTE_CURSOR = ">";

    public static void main(String[] args) {

        UsageFileWriter app = new UsageFileWriter();
        String name = "山本一郎";
        int usageCount = 5;

        Usage usage = new Usage(name, usageCount);

        try {
            FileManager.createDirIfNotExists(DIR_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileManager.createFileIfNotExists(FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<String> lines = new ArrayList<>();
        usage.createUsageContent(
            lines, usage.getName(), usage.getUsageCount());
        
        try {
            FileManager.writeToFile(FILE_PATH, lines);   
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> readLines = new ArrayList<>();
        try {
            readLines = FileManager.readFileAllContents(FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logger.log("ファイル内容を表示します...");
        app.showContents(readLines);
    }

    private void showContents(List<String> readLines) {
        for (String line : readLines) {
            System.out.printf("%s %s %n", QUOTE_CURSOR, line);
        }
    }
}
