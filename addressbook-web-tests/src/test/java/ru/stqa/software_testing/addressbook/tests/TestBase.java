package ru.stqa.software_testing.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.software_testing.addressbook.appManager.ApplicationManager;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {

  protected static final ApplicationManager application = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    application.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    application.stop();

  }
  public void verifyGroupListInUI() {

    if(Boolean.getBoolean("verifyUI")){
      Groups dbGroups = application.db().groups();
      Groups uiGroups = application.group().set();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));

    }

  }

}
