package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModification() {

    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    application.getGroupHelper().modificationGroup(new GroupData("change1", "test", "change3"));
    application.getSessionHelper().logOut();

  }

}
