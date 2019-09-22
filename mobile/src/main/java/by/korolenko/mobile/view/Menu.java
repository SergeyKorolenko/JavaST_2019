package by.korolenko.mobile.view;

import by.korolenko.mobile.controller.Controller;

import java.util.Scanner;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
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
    private void showResponse(final String response) {
        System.out.println(response);
    }

    /**
     * This method is for entering common info about tariff.
     *
     * @return common info as a string
     */
    private String enterCommonInfo() {
        String info = "";
        System.out.println("Enter name of tariff:");
        info += scanner.nextLine() + ",";
        System.out.println("Enter tariff rate:");
        info += scanner.nextLine() + ",";
        System.out.println("Enter number of free minute");
        info += scanner.nextLine() + ",";
        System.out.println("Enter number of free traffic:");
        info += scanner.nextLine() + ",";
        return info;
    }

    /**
     * This method is fo entering tariff type.
     *
     * @return tariff
     */
    private String enterTariff() {
        System.out.println("Choose tariff type:\n1 - HOME\n"
                + "2 - BUSINESS\n3 - SOCIAL");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                return "HOME," + enterCommonInfo() + enterChannel();
            case "2":
                return "BUSINESS," + enterCommonInfo() + enterRoaming();
            case "3":
                return "SOCIAL," + enterCommonInfo() + enterMessenger();
            default:
                return "WRONG";
        }
    }

    /**
     * This method is for entering channel.
     *
     * @return channel
     */
    private String enterChannel() {
        System.out.println("Enter number of channels:");
        return scanner.nextLine();
    }

    /**
     * This method is for entering roaming.
     *
     * @return roaming
     */
    private String enterRoaming() {
        System.out.println("Enter number of roaming minutes:");
        return scanner.nextLine();
    }

    /**
     * This method is for entering messenger.
     *
     * @return messenger
     */
    private String enterMessenger() {
        System.out.println("Enter messenger:");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * This method is for entering id.
     *
     * @return id as a string
     */
    private String enterId() {
        System.out.println("Enter id");
        return scanner.nextLine();
    }

    /**
     * This method is for entering name.
     *
     * @return name as a string
     */
    private String enterName() {
        System.out.println("Enter name");
        return scanner.nextLine();
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
            System.out.println("Enter a point of the menu:");
            String point = scanner.nextLine();
            switch (point) {
                case "1":
                    request = "READ_FROM_FILE,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "2":
                    request = "ADD_TARIFF," + enterTariff();
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "3":
                    request = "DELETE_TARIFF," + enterTariff() + ","
                            + enterId();
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "4":
                    request = "UPDATE_TARIFF," + enterTariff() + ","
                            + enterId();
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
                    request = "FIND_BY_ID," + enterId();
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "9":
                    request = "FIND_BY_NAME," + enterName();
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "10":
                    request = "FIND_BETWEEN_ID," + enterId() + "," + enterId();
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
    private void showMenu() {
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
