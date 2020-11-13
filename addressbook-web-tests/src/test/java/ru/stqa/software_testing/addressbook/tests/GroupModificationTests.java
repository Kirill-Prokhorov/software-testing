package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModification() {

    application.getNavigationHelper().gotoGroupPage();
    int before = application.getGroupHelper().getGroupCount();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    application.getGroupHelper().modificationGroup(new GroupData("change1", "test", "change3"), before - 1);
    int after = application.getGroupHelper().getGroupCount();
    Assert.assertEquals( after, before );
    application.getSessionHelper().logOut();

  }

}
