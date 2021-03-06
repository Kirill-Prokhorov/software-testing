package ru.stqa.software_testing.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  WebDriver wd;
  String browser;
  public SessionHelper sessionHelper;
  public NavigationHelper navigationHelper;
  public GroupHelper groupHelper;
  public ContactHelper contactHelper;
  private DbHelper dbHelper;

  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));

    dbHelper = new DbHelper();

    if("".equals(properties.getProperty("selenium.server"))) {
      if (browser.equalsIgnoreCase(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equalsIgnoreCase(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
    }
    else {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName(browser);
      capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "")));
      wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }


  public void stop() {
    wd.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public DbHelper db(){

    return dbHelper;
  }
}
