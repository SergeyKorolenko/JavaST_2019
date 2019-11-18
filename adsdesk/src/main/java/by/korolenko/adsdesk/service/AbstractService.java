package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.dao.WrapperConnection;

abstract public class AbstractService {

    protected WrapperConnection wrapperConnection;

    public void setWrapperConnection(WrapperConnection wrapperConnection) {
        this.wrapperConnection = wrapperConnection;
    }
}
