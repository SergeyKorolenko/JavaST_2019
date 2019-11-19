package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.dao.WrapperConnection;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
abstract public class AbstractService {

    protected WrapperConnection wrapperConnection;

    public void setWrapperConnection(WrapperConnection wrapperConnection) {
        this.wrapperConnection = wrapperConnection;
    }
}
