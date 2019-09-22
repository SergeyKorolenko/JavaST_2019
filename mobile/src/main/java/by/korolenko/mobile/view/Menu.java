package by.korolenko.mobile.view;

import by.korolenko.mobile.controller.Controller;

import java.util.Scanner;

public class Menu {

    /**
     * This is the object of the contriller class.
     */
    private final Controller controller = new Controller();
    /**
     * This is the scanner.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method prints response.
     *
     * @param response response string
     */
    public void showResponse(final String response) {
        System.out.println(response);
    }

    /**
     * Start menu.
     */
    public void start() {
        String request;
        String response;
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.println("Enter number:");
            String point = scanner.nextLine();
            switch (point) {
                case "1":
                    request = "READ_FROM_FILE,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "2":
                    request = "ADD_TARIFF,HOME,temp,15.5,4,8,45";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "3":
                    request = "DELETE_TARIFF,HOME,temp1,15.5,4,8,45,1";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "4":
                    request = "UPDATE_TARIFF,HOME,temp2,15.5,25,8,45,1";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "5":
                    request = "GET_ALL,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "6":
                    request = "SORT_BY_ID,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "7":
                    request = "SORT_BY_NAME,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "8":
                    request = "FIND_BY_ID,1";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "9":
                    request = "FIND_BY_NAME,temp1";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "10":
                    request = "FIND_BETWEEN_ID,1,3";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "11":
                    flag = false;
                    break;
                default:
                    System.out.println("Enter right number:");
            }
        }
        scanner.close();
    }

    /**
     * This method prints menu.
     */
    public void showMenu() {
        System.out.println("1 - read from file\n"
                + "2 - add tariff\n"
                + "3 - delete tariff\n"
                + "4 - update tariff\n"
                + "5 - get all tariff\n"
                + "6 - sort by id\n"
                + "7 - sort by name\n"
                + "8 - search by id\n"
                + "9 - search by name\n"
                + "10 - search between id\n"
                + "11 - exit");
    }
}
