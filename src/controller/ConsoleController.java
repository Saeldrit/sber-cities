package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private static final List<String> MENU;
    private final Scanner scanner;
    private final ConsolePrintOut consolePrintOut;
    private String directory;

    static {
        MENU = new ArrayList<>();
        initializationMenu();
    }

    public ConsoleController(int numberOfFile) {
        this.directory = "resources";
        this.scanner = new Scanner(System.in);
        this.consolePrintOut = new ConsolePrintOut(numberOfFile, directory);
    }

    public static void setMenu(String item) {
        MENU.add(item);
    }

    private static void initializationMenu() {
        setMenu("1 - Вывести все города");
        setMenu("2 - Города сортированные по названиям");
        setMenu("3 - Города сортированные по округу и названию");
        setMenu("4 - Город с максимальным населением");
        setMenu("5 - Вывести количество городов по региону");
        setMenu("0 - Выход");
    }

    private void setDirectory(String directory) {
        this.directory = directory;
    }

    public List<String> getMenu() {
        return MENU;
    }

    public void postConstruct() {
        String dirDefault = "Директория по умолчанию " + directory;
        System.out.println(dirDefault);
        System.out.println("Указать другой путь? Введите да / нет");

        String ask = scanner.next();

        if (ask.equalsIgnoreCase("да")) {
            System.out.println("Укажите путь к файлу");
            ask = scanner.next();
            setDirectory(ask);
            System.out.println(dirDefault);
        }
        printMenu();
    }

    private void printMenu() {
        getMenu().forEach(System.out::println);
        System.out.print("Ввод - ");
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            processingMenuItems(userInput);
            getMenu().forEach(System.out::println);
            System.out.print("Ввод - ");
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private void processingMenuItems(int item) {
        switch (item) {
            case 1 -> consolePrintOut.printCities();
            case 2 -> consolePrintOut.printSortCitiesByName();
            case 3 -> consolePrintOut.printSortCitiesByDistrictAndName();
            case 4 -> consolePrintOut.printCityOfMaximumPopulation();
            case 5 -> consolePrintOut.printCountCitiesByRegion();
            default -> System.err.println("Давай еще разок");
        }
    }
}
