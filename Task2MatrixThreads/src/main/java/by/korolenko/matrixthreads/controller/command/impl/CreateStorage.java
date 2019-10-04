package by.korolenko.matrixthreads.controller.command.impl;

import by.korolenko.matrixthreads.controller.command.Command;
import by.korolenko.matrixthreads.service.StorageCreatingService;
import by.korolenko.matrixthreads.service.factory.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 25.09.2019
 */
public class CreateStorage implements Command {
    /**
     * Execute method.
     *
     * @return response
     */
    @Override
    public String execute() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        StorageCreatingService storageCreatingService = serviceFactory.
                getStorageCreatingService();
        return storageCreatingService.createStorage();
    }
}
