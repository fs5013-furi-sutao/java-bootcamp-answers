package master.trywith.resource.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Transcriptor {

    private static final String TARGET_FILE_RELATIVE_PATH_FOR_READING 
            = "./testRead.txt";
    
        private static final String TARGET_FILE_RELATIVE_PATH_FOR_WRITING 
            = "./testWrite.txt";
    
        public static void main(String[] args) {

        // try (Scanner scanner = new Scanner(new File("./testRead.txt"));
        // PrintWriter writer = new PrintWriter(new File("./testWrite.txt"))) {
        // while (scanner.hasNext()) {
        // writer.print(scanner.nextLine());
        // }
        // } catch (FileNotFoundException fnfe) {
        // System.out.println("ファイルがありません");
        // fnfe.printStackTrace();
        // }

        Scanner scanner = null;
        PrintWriter writer = null;

        try {
            scanner = new Scanner(
                new File(TARGET_FILE_RELATIVE_PATH_FOR_READING));

            writer = new PrintWriter(
                new File(TARGET_FILE_RELATIVE_PATH_FOR_WRITING));
                
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            ExceptionHolder holder = new ExceptionHolder(e);
            holder.showExceptionMessage();
            holder.showStackTrace();

        } finally {
            if (writer != null) writer.flush();
            if (scanner != null) scanner.close();
        }
    }
}
