package ru.stqa.software_testing.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase{


  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {

    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
   type(By.name("username"), username);
   type(By.name("email"),email);
    click(By.cssSelector("input[value='Зарегистрироваться']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    wd.findElement(By.tagName("button")).click();
  }

  public void resetPassword(String user){
    click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
    click(By.linkText("Управление пользователями"));
    click(By.linkText(user));
    click(By.xpath("//input[@value='Сбросить пароль']"));
  }

  public void login (String username, String password)
  {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.id("username"), username);
    click(By.xpath("//input[@value='Войти']"));
    type(By.id("password"), password);
    click(By.xpath("//input[@value='Войти']"));
  }

}
