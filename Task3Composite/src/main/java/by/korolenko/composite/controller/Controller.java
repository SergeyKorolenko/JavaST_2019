package by.korolenko.composite.controller;

import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.impl.CompositeServiceImpl;

public final class Controller {
    private Controller() {
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        CompositeService service = new CompositeServiceImpl();
        service.add();
        service.collect();
    }
}
