package by.korolenko.adsdesk.dao.pool;

import java.util.ResourceBundle;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
final class DbDataConnection {

    private String driver;
    private String url;
    private String user;
    private String pass;
    private int poolSize;

    DbDataConnection() {
        ResourceBundle bundle = ResourceBundle.getBundle("dbparameters");
        driver = bundle.getString("db.driver");
        url = bundle.getString("db.url");
        user = bundle.getString("db.login");
        pass = bundle.getString("db.password");
        poolSize = Integer.parseInt(bundle.getString("db.poolSize"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
