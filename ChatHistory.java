import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;


public class ChatHistory {


    static void doWriteString(String name, String message) throws Exception {
        File recordsFile = new File("E:\\Новая папка\\untitled1\\src\\records.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(recordsFile, true));
        writer.newLine();
        writer.append(name + " : " + message);

        writer.flush();
    }

    static void doWriteStringToHist(String string) throws Exception {
        File recordsFile = new File("E:\\Новая папка\\untitled1\\src\\History.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(recordsFile, true));
        writer.newLine();
        writer.append("\n" + string);

        writer.flush();
    }

    private static void deleteHistory() throws Exception {
        File recordsFile = new File("E:\\Новая папка\\untitled1\\src\\History.txt");
        FileOutputStream fout = new FileOutputStream(recordsFile);
        String newRecord = "История сообщений:";
        fout.write(newRecord.getBytes());
    }


    static void lastHistory() throws Exception {
        Stream<String> lines2 = Files.lines(Paths.get("E:\\Новая папка\\untitled1\\src\\records.txt"));

        long linesCount = lines2.count();
        System.out.println("Number of lines: " + linesCount);
        deleteHistory();
        try (RandomAccessFile raf = new RandomAccessFile("E:\\Новая папка\\untitled1\\src\\records.txt", "r")) {
            for (int i = 0; i < linesCount; i++) {
                if (i < linesCount - 100) {
                    raf.readLine();
                }
                if (i >= linesCount - 100) {
                    doWriteStringToHist(raf.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


