package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.dao.Transaction;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public abstract class AbstractService {

    protected Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
