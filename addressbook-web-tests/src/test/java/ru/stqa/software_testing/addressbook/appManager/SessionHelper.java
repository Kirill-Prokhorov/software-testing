package ru.stqa.software_testing.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver wd) {
    super(wd);
  }
  public void login(String username, String password) {

    type(By.name("user"), username);
    type(By.name("pass"), password);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    click(By.xpath("//input[@value='Login']"));
  }
  public void logOut() {
    click(By.linkText("Logout"));
  }
}
