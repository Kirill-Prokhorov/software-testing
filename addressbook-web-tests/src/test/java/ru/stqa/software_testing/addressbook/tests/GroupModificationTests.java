package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModification() {

    application.getNavigationHelper().gotoGroupPage();
    application.getGroupHelper().selectGroup();
    application.getGroupHelper().initGroupModification();
    application.getGroupHelper().fillGroupForm(new GroupData("change1", "test", "change3"));
    application.getGroupHelper().submitGroupModification();
    application.getGroupHelper().returnToGroupPage();
  }

}
