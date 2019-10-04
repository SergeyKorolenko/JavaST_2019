package by.korolenko.matrixthreads.view;

import by.korolenko.matrixthreads.controller.Controller;

import java.util.Scanner;

public class Menu {

    /**
     * This is the object of the contriller class.
     */
    private final Controller controller = new Controller();
    /**
     * Scanner.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Menu starter.
     */
    public void start() {
        showResponse(controller.executeRequest("CREATE_STORAGE"));
        boolean flag = true;
        while (flag) {
            showMenu();
            String point = scanner.nextLine();
            switch (point) {
                case "1":
                    showResponse(controller.executeRequest("LOCK"));
                    break;
                case "2":
                    showResponse(controller.executeRequest("SEMAPHORE"));
                    break;
                case "3":
                    showResponse(controller.executeRequest("3"));
                    break;
                case "4":
                    showResponse(controller.executeRequest("4"));
                    break;
                case "5":
                    showResponse(controller.executeRequest("5"));
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Enter right number:");
            }
        }

    }

    /**
     * This method prints menu.
     */
    private void showMenu() {
        System.out.println("1 - use lock\n"
                + "2 - use semaphore\n"
                + "3 - use third method\n"
                + "4 - use fourth method\n"
                + "5 - use fifth method\n"
                + "6 - exit");
    }

    /**
     * This method prints response.
     *
     * @param response response string
     */
    private void showResponse(final String response) {
        System.out.println(response);
    }
}
