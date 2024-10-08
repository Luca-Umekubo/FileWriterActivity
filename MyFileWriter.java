
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {

    private static void printTotalFileSize(String... fileNames) {
    
        System.out.println("Total size of all files: ...TBD... bytes");
    }
    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //hidden File Method
        try (BufferedWriter hiddenWriter = new BufferedWriter(new FileWriter(".verySecret.txt"))){
            hiddenWriter.write("superSecretEpicPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

         //hidden Folder Method
         try (BufferedWriter hiddenWriter = new BufferedWriter(new FileWriter(".sneakyFolder/topSecret.dat"))){
            hiddenWriter.write("valuable data right here ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}