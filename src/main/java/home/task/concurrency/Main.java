package home.task.concurrency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final Object lock = new Object();

    private static long counter = 0;

    private static ArrayList<Double> result = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        String path = "C:\\Users\\Three\\IdeaProjects\\HomeWork\\src\\numberFile.txt";
        createNewFile(path);
        FileWriter fileWriter = new FileWriter(path);
        calculateSqrt(fileWriter, 25, 1000000);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println(result.size());


    }

     static void createNewFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }

    private static void calculateSqrt (FileWriter fileWriter, int countOfThreads, int numbers) throws IOException, InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int threadNumber = 0; threadNumber < countOfThreads; threadNumber++) {
            Thread thread = startNewJob(numbers / countOfThreads);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (Double aDouble : result) {
            fileWriter.write((aDouble) + "\n");
        }
    }
    private static Thread startNewJob(int iterations) {
        return new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                synchronized (lock) {
                    counter++;
                    result.add(Math.sqrt(counter));
                }
            }
        });
    }
}

    
