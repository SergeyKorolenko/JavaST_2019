package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.dao.Transaction;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public abstract class AbstractService {

    protected Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
