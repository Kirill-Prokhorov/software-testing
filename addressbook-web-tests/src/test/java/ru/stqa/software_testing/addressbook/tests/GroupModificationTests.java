package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().list().size() == 0){
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
    }
    application.goTo().groupPage();
  }

  @Test
  public void groupModification() {



    List<GroupData> before = application.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(before.size() - 1).getId()).withName("change1").withHeader("test").withFooter("change3");
    application.group().modify(index, group );
    application.goTo().groupPage();
    List<GroupData> after = application.group().list();
    Assert.assertEquals( after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    //Assert.assertEquals( new HashSet<>(before), new HashSet<>(after));


  }

}
