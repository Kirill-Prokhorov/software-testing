package ru.stqa.software_testing.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.software_testing.mantis.model.User;
import ru.stqa.software_testing.mantis.model.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(ApplicationManager applicationManager) {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();


    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

  }


  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<User> result = session.createQuery("from User ").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }


}
