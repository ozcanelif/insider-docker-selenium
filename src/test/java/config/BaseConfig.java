package config;

public class BaseConfig {

    public static BaseConfig getInstance() {
        return new BaseConfig();
    }

    public static final int SHORT_WAIT_TIMEOUT_SECONDS = 5;
    public static final int MODERATE_WAIT_TIMEOUT_SECONDS = 15;
    public static final int GLOBAL_WAIT_TIMEOUT_SECONDS = 30;
    public static final int LONG_WAIT_TIMEOUT_SECONDS = 60;

    String browser = System.getProperty("browser");
    String env = System.getProperty("env");
    String headless = System.getProperty("headless");
    String threadCount = System.getProperty("threadCount");
    String remoteUrl = System.getProperty("remoteUrl");
    public String getBrowser() {
        return (browser != null) ? browser : "chrome";
    }

    public String getUrl() {
        env = (env != null) ? env : "test";
        String url = null;
        switch (env) {
            case "test" -> url = "https://useinsider.com/";
            case "prod" -> url = "https://useinsider.com/";
        }
        return url;
    }

    public String getRemoteUrl(){
        return (remoteUrl != null) ? remoteUrl : "http://selenium-hub:4444/";
    }

    public Boolean getHeadless() {
        return Boolean.parseBoolean(headless);
    }

    public String getThreadCount() {
        return (threadCount != null) ? threadCount : "3";
    }
}