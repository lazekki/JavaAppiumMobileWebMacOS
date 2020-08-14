package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android",
            PLATFORM_MOBILE_WEB = "mobile_web",
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {

        URL URL = new URL(APPIUM_URL);

        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return  new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isMw()) {
            return new ChromeDriver(this.getMwChromeOptions());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMw() {return isPlatform(PLATFORM_MOBILE_WEB); }

    private DesiredCapabilities getAndroidDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app.package", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/olgazaharenko/Desktop/JavaAppiumAutomationMacOS/apks/org.wikipedia.apk");

        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("app", "/Users/olgazaharenko/Desktop/JavaAppiumAutomationMacOS/apks/wikipedia.app");

        return  capabilities;
    }

    private ChromeOptions getMwChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 720);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetris", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D)" +
                "AppleWebKit/535.19 (KHTML, like Gecko) " +
                "Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,720");

        return chromeOptions;
    }

    public String getPlatformVar() {

        return System.getenv("PLATFORM");
    }

    private boolean isPlatform(String my_platform) {

        return my_platform.equals(this.getPlatformVar());
    }

}
