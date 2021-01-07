import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {
    
    private FileManager() {
        throw new IllegalStateException(
                "インスタンス化しないでください."
            );
    }

    public static void createDirIfNotExists(Path path)
            throws IOException {

        if (Files.exists(path)) {

            String message = String.format("%s は既に存在します.",
                    path.toAbsolutePath().toString());

            Logger.log(message);
            return;
        }
        createDir(path);
    }

    public static void createFileIfNotExists(Path path) 
            throws IOException {

        if (Files.exists(path)) {

            String message = 
                String.format("%s は既に存在します.",
                    path.toAbsolutePath().toString()
                );
                
            Logger.log(message);
            return;
        }
        createFile(path);
    }

    private static void createDir(Path path) throws IOException {
        Files.createDirectory(path);
    }

    private static void createFile(Path path) throws IOException {
        Files.createFile(path);
    }

    static void writeToFile(Path path, List<String> lines) 
            throws IOException {

        Files.write(path, lines);
    }

    static List<String> readFileAllContents(Path path)
            throws IOException {

        return Files.readAllLines(path);
    }
}
