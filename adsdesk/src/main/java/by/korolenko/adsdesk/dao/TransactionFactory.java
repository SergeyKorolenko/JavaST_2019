package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.dao.transaction.TransactionImpl;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface TransactionFactory {

    TransactionImpl createWrapperConnection();

    void close();
}
