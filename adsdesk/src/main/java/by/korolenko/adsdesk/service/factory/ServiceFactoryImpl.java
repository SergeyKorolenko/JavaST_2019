package by.korolenko.adsdesk.service.factory;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.WrapperConnection;
import by.korolenko.adsdesk.dao.WrapperConnectionFactory;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.impl.*;

public class ServiceFactoryImpl implements ServiceFactory {

    private WrapperConnectionFactory wrapperConnectionFactory;

    public ServiceFactoryImpl(WrapperConnectionFactory wrapperConnectionFactory) {
        this.wrapperConnectionFactory = wrapperConnectionFactory;
    }

    @Override
    public AbstractService createService(EntityType entityType) {
        AbstractService service = null;
        WrapperConnection wrapperConnection =
                wrapperConnectionFactory.createWrapperConnection();
        switch (entityType) {
            case LOCALITY:
                service = new LocalityServiceImpl();
                break;
            case CATEGORY:
                service = new CategoryServiceImpl();
                break;
            case COUNTRY:
                service = new CountryServiceImpl();
                break;
            case COMMENT:
                service = new CommentServiceImpl();
                break;
            case REGION:
                service = new RegionServiceImpl();
                break;
            case IMAGE:
                service = new ImageServiceImpl();
                break;
            case USER:
                service = new UserServiceImpl();
                break;
            case ADS:
                service = new AdsServiceImpl();
                break;
        }
        service.setWrapperConnection(wrapperConnection);
        return service;
    }

    @Override
    public void close() {
        wrapperConnectionFactory.close();
    }
}
