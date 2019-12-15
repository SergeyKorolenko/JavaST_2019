package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.bean.enums.State;
import by.korolenko.adsdesk.dao.factory.TransactionFactoryImpl;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;
import by.korolenko.adsdesk.service.factory.ServiceFactoryImpl;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

import java.util.Date;

public class UserServiceImplTest {

    private ServiceFactory factory;

    private UserService userService;

    private int countUser = 2;

    @BeforeTest
    public static void init() {
        ConnectionPool.getInstance();
    }

    @BeforeMethod
    public void createService() {
        factory = new ServiceFactoryImpl(new TransactionFactoryImpl());
        userService = factory.createService(EntityType.USER);
    }

    @DataProvider(name = "userForRegister")
    public Object[] createUserForRegister() {
        return new Object[]{
                new User("test1", "0aA@password1", Role.USER,
                        "Sergei", 375291897586L, new Date(),
                        State.ACTIVE, "user1@gmail.com"),
                new User("test2", "0aA@password2", Role.USER,
                        "Andrey", 375291855586L, new Date(),
                        State.ACTIVE, "user2@gmail.com"),
                new User("test3", "0aA@password3", Role.USER,
                        "Alex", 375291897586L, new Date(),
                        State.ACTIVE, "user3@gmail.com"),
                new User("test4", "0aA@password4", Role.USER,
                        "Igor", 375291897586L, new Date(),
                        State.ACTIVE, "user4@gmail.com"),
                new User("test5", "0aA@password5", Role.USER,
                        "Yagor", 375291897586L, new Date(),
                        State.ACTIVE, "user5@gmail.com"),
                new User("test6", "0aA@password6", Role.USER,
                        "Vera", 375338967586L, new Date(),
                        State.ACTIVE, "user6@gmail.com"),
                new User("test7", "0aA@password7", Role.USER,
                        "Lena", 375291897586L, new Date(),
                        State.ACTIVE, "user7@gmail.com"),
                new User("test8", "0aA@password8", Role.USER,
                        "Veronika", 375291897986L, new Date(),
                        State.ACTIVE, "user8@mail.ru"),
        };
    }

    @Test(description = "user register", dataProvider = "userForRegister")
    public void registerTest(User user) throws ServiceException {
        userService.register(user);
        int actual = userService.countUser();
        int expected = ++countUser;
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void destroyService() {
        userService = null;
        factory.close();
    }

    @AfterTest
    public static void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
