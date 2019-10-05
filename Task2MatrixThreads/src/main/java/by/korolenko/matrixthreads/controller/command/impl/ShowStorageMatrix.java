package by.korolenko.matrixthreads.controller.command.impl;

import by.korolenko.matrixthreads.controller.command.Command;
import by.korolenko.matrixthreads.service.StorageService;
import by.korolenko.matrixthreads.service.factory.ServiceFactory;

public class ShowStorageMatrix implements Command {
    /**
     * Execute method.
     *
     * @return response
     */
    @Override
    public String execute() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        StorageService storageService = serviceFactory.
                getStorageService();
        return storageService.showStorageData();
    }
}
