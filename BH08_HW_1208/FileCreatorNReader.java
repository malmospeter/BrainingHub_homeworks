package oophw1208files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileCreatorNReader {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    static final String PATH = "C:\\FilesToJuniorJava\\";

    static long totalNumberOfRowsThreads = 0;
    static long totalNumberOfRowsClassic = 0;

    public static void main(String[] args) {

        int filesCount;

        do {
            System.out.print("How many files You want to create? ");
            filesCount = sc.nextInt();
        } while (filesCount < 0 || filesCount > 50);

        //writing to files
        createFilesWithContentinLines(filesCount);

        //reading from files with threads
        long startT = System.currentTimeMillis();
        for (int i = 0; i < filesCount; i++) {
            String file = PATH.concat("szoveg" + i + ".txt");
            File readFromFile = new File(file);

            try {
                Thread t = new Thread(new CountWithThreads(readFromFile));
                t.start();
            } catch (FileNotFoundException ex) {
                System.out.println("Missing file!: " + ex.getMessage());
            }
        }
        long endT = System.currentTimeMillis();

//        reading from file without threads
        long start = System.currentTimeMillis();
        for (int i = 0; i < filesCount; i++) {
            String file = PATH.concat("szoveg" + i + ".txt");
            File readFromFile = new File(file);

            try {
                int numberOfRows = countLinesinFile(readFromFile);
                totalNumberOfRowsClassic += numberOfRows;
                System.out.println("WithoutThreads Rows in " + readFromFile.getName() + "  " + numberOfRows);
            } catch (FileNotFoundException ex) {
                System.out.println("Missing file!: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Something went wrong with accessing file! The reason: " + ex.getMessage());
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Total number of rows: " + totalNumberOfRowsClassic + " in " + filesCount + "file(s). (without threads)" + "running time: " + (end - start));
        System.out.println("Total number of rows: " + totalNumberOfRowsThreads + " in " + filesCount + "file(s).(with threads)" + "running time: " + (endT - startT));

    }

    private static class CountWithThreads implements Runnable {

        private BufferedReader br;
        private File file;
        private int count;

        public CountWithThreads(File file) throws FileNotFoundException {
            this.br = new BufferedReader(new FileReader(file));
            this.count = 0;
            this.file = file;
        }

        @Override
        public void run() {
            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    ++count;
                }
                System.out.println("WithThreads Rows in " + file.getName() + "  " + count);
                totalNumberOfRowsThreads += count;
            } catch (IOException ex) {
                System.out.println("Something went wrong with accessing file! The reason: " + ex.getMessage());
            }
        }
    }

    private static void createFilesWithContentinLines(int count) {
        for (int i = 0; i < count; i++) {
            String file = PATH.concat("szoveg" + i + ".txt");
            int totalRow = 100000 + rnd.nextInt(10000) * count;

            File writeToFile = new File(file);

            try {
                writeLinesToFile(writeToFile, totalRow);
            } catch (IOException ex) {
                System.out.println("Something went wrong with creating file! The reason: " + ex.getMessage());
            }
        }
    }

    private static void writeLinesToFile(File file, int numberOfLines) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            for (int j = 0; j < numberOfLines; j++) {
                fw.write((j + 1) + " a little game with files\n");
            }
        }
    }

    private static int countLinesinFile(File file) throws FileNotFoundException, IOException {
        int count;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            count = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                ++count;
            }
        }

        return count;
    }

}
