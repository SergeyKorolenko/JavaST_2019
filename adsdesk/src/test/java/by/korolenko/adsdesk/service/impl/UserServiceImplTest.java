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

    private int countUser = 5;

    @BeforeSuite
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

    @Test(dataProvider = "userForRegister")
    public void registerTest(User user) throws ServiceException {
        userService.register(user);
        int actual = userService.countUser();
        int expected = ++countUser;
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForLogin")
    public Object[][] createDataForLogin() {
        return new Object[][]{
                {new String[]{"test1", "0aA@password1"}, new User("test1", Role.USER, "Sergei")},
                {new String[]{"test2", "0aA@password2"}, new User("test2", Role.USER, "Andrey")},
                {new String[]{"test3", "0aA@password3"}, new User("test3", Role.USER, "Alex")},
                {new String[]{"test4", "0aA@password4"}, new User("test4", Role.USER, "Igor")},
                {new String[]{"test5", "0aA@password5"}, new User("test5", Role.USER, "Yagor")},
                {new String[]{"test6", "0aA@password6"}, new User("test6", Role.USER, "Vera")},
                {new String[]{"test7", "0aA@password7"}, new User("test7", Role.USER, "Lena")},
                {new String[]{"test8", "0aA@password8"}, new User("test8", Role.USER, "Veronika")},
        };
    }

    @Test(dataProvider = "dataForLogin", dependsOnMethods = "registerTest")
    public void findByLoginAndPasswordTest(String[] array, User expected) throws ServiceException {
        User actual = userService.findByLoginAndPassword(array[0], array[1]);
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getRole(), expected.getRole());
    }

    @Test(dataProvider = "userForRegister", expectedExceptions = ServiceException.class, dependsOnMethods = "findByLoginAndPasswordTest")
    public void registerWrongTest(User user) throws ServiceException {
        userService.register(user);
    }

    @AfterMethod
    public void destroyService() {
        userService = null;
        factory.close();
    }

    @AfterSuite
    public static void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
