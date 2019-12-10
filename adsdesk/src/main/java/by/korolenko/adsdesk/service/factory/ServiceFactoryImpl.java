package by.korolenko.adsdesk.service.factory;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.Transaction;
import by.korolenko.adsdesk.dao.TransactionFactory;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.impl.*;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private TransactionFactory transactionFactory;

    public ServiceFactoryImpl(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    @Override
    public <T extends AbstractService> T createService(EntityType entityType) {
        AbstractService service = null;
        Transaction transaction =
                transactionFactory.createWrapperConnection();
        switch (entityType) {
            case LOCALITY:
                service = new LocalityServiceImpl();
                break;
            case CATEGORY:
                service = new CategoryServiceImpl();
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
        if (service != null) {
            service.setTransaction(transaction);
        }
        return (T) service;
    }

    @Override
    public void close() {
        transactionFactory.close();
    }
}
