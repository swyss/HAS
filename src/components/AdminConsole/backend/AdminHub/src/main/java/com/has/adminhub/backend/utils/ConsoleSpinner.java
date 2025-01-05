package com.has.adminhub.backend.utils;

public class ConsoleSpinner {
    private static final char[] SPINNER = {'|', '/', '-', '\\'};

    public static void showSpinner(String message, int durationInSeconds) {
        System.out.print(message);
        int index = 0;
        long endTime = System.currentTimeMillis() + durationInSeconds * 1000;
        while (System.currentTimeMillis() < endTime) {
            System.out.print("\r" + message + " " + SPINNER[index++ % SPINNER.length]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\r" + message + " Done!");
    }
}
