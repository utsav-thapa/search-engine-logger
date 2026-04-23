package com.pluralsight;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Search();
    }

    public static void Search() {
        Scanner scanner = new Scanner(System.in);


        boolean running = true;
        try {
            FileWriter fWriter = new FileWriter("src/main/resources/key-logger.txt");
            LocalDateTime timeLocal = LocalDateTime.now();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = timeLocal.format(formatter1);
            fWriter.write(time + " launch" + "\n");

            while (running) {
                LocalDateTime rightAboutNow = LocalDateTime.now();
                String programTime = rightAboutNow.format(formatter1);
                System.out.print("Enter a search term (X to exit): ");
                String userInput = scanner.nextLine();
                if (userInput.equals("X")) {
                    System.out.println("You have exited the program.");
                    running = false;
                    fWriter.write(programTime + " exit");
                    fWriter.close();
                }
                else {
                    fWriter.write(programTime + " search : " + userInput +"\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Something went wrong bro!");
        }

    }
}