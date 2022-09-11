import controller.ConsoleController;

public class Main {
    public static void main(String[] args) {
        ConsoleController  controller = new ConsoleController(0, "resources");

        controller.printSortContentByDistrictAndName();
    }
}
