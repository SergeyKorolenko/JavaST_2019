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
        Boolean isStart = new Boolean(controller.
                executeRequest("CREATE_STORAGE"));
        if (isStart) {
            boolean flag = true;
            while (flag) {
                showMenu();
                String point = scanner.nextLine();
                switch (point) {
                    case "1":
                        showResponse(controller.
                                executeRequest("SHOW_STORAGE_MATRIX"));
                        break;
                    case "2":
                        showResponse(controller.executeRequest("LOCK"));
                        break;
                    case "3":
                        showResponse(controller.executeRequest("SEMAPHORE"));
                        break;
                    case "4":
                        showResponse(controller.executeRequest("CALLABLE"));
                        break;
                    case "5":
                        showResponse(controller.executeRequest("PHASER"));
                        break;
                    case "6":
                        showResponse(controller.executeRequest("5"));
                        break;
                    case "7":
                        flag = false;
                        break;
                    default:
                        System.out.println("Enter right number:");
                }
            }
        } else {
            System.out.println("Creating storage error");
        }
    }

    /**
     * This method prints menu.
     */
    private void showMenu() {
        System.out.println("1 - show storage matrix\n"
                + "2 - use lock\n"
                + "3 - use semaphore\n"
                + "4 - use callable\n"
                + "5 - use phaser\n"
                + "6 - use fifth method\n"
                + "7 - exit");
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
