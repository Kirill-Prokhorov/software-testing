package ru.stqa.software_testing.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.software_testing.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends  TestBase{

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newHttpSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}