package by.korolenko.matrixthreads.controller.command.impl;

import by.korolenko.matrixthreads.controller.command.Command;
import by.korolenko.matrixthreads.service.MatrixFillingService;
import by.korolenko.matrixthreads.service.factory.ServiceFactory;

public class UseCallable implements Command {
    /**
     * Execute method.
     *
     * @return response
     */
    @Override
    public String execute() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixFillingService matrixFillingService = serviceFactory.
                getMatrixFillingService();
        return matrixFillingService.fillByCallable();
    }
}
