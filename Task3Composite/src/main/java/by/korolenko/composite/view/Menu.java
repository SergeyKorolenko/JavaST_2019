package by.korolenko.composite.view;

import by.korolenko.composite.controller.Controller;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class Menu {

    /**
     * Controller.
     */
    private final Controller controller = new Controller();
    /**
     * This is the scanner.
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Resource bundle.
     */
    private ResourceBundle rb;

    /**
     * Constructor.
     */
    public Menu() {
        System.out.println("1 — english\n"
                + "2 — russian");
        String country = "";
        String language = "";
        switch (scanner.nextLine()) {
            case "1":
                break;
            case "2":
                country = "RU";
                language = "ru";
                break;
            default:
        }
        Locale current = new Locale(language, country);
        rb = ResourceBundle.
                getBundle("property.text", current);
    }

    /**
     * This method prints response.
     *
     * @param response response string
     */
    private void showResponse(final String response) {
        System.out.println(response);
    }

    /**
     * This method prints menu.
     */
    private void showMenu() {
        System.out.println("1 - " + rb.getString("p1") + "\n"
                + "2 - " + rb.getString("p2") + "\n"
                + "3 - " + rb.getString("p3") + "\n"
                + "4 - " + rb.getString("p4") + "\n"
                + "5 - " + rb.getString("p5") + "\n"
                + "6 - " + rb.getString("p6"));
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
            System.out.println(rb.getString("menu"));
            String point = scanner.nextLine();
            switch (point) {
                case "1":
                    request = "PARSE_TEXT,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "2":
                    request = "COLLECT_TEXT,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "3":
                    request = "SORT_BY_SENTENCE_COUNT,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "4":
                    request = "SORT_BY_WORD_LENGTH,";
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "5":
                    request = "SORT_LEXEME_BY_SYMBOL," + enterSymbol();
                    response = controller.executeRequest(request);
                    showResponse(response);
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println(rb.getString("error"));
            }
        }
        scanner.close();
    }

    private String enterSymbol() {
        System.out.println(rb.getString("symbol"));
        return scanner.nextLine();
    }
}
