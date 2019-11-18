package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.dao.wrapper.WrapperConnectionImpl;

public interface WrapperConnectionFactory {

    WrapperConnectionImpl createWrapperConnection();

    void close();
}
