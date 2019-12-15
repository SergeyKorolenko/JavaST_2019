package by.korolenko.adsdesk.dao.pool;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
final class DbDataConnection {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/ads_desk?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "adsdesk_user";
    private String password = "adsdesk_password";
    private int poolSize = 100;

    DbDataConnection() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
