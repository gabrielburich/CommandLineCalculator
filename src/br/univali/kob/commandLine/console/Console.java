package br.univali.kob.commandLine.console;

import java.util.Scanner;

/**
 * Class to read and print information on console
 */
public class Console {

    private Scanner scanner;

    /**
     * Default Class constructor
     */
    public Console() {
        scanner = new Scanner(System.in);
    }

    /**
     * Read a string from console
     *
     * @return
     */
    public String readString() {
        return scanner.nextLine();
    }

    /**
     * Print a message on console in next line
     *
     * @param message Object calls to string
     */
    public void println(Object message) {
        System.out.println(message.toString());
    }

    /**
     * Print a message on console
     *
     * @param message Object calls to string
     */
    public void print(Object message) {
        System.out.print(message.toString());
    }


}