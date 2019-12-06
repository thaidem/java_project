package ru.stqa.project.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.project.mantis.model.UserData;
import ru.stqa.project.mantis.model.Users;


import java.util.List;

public class DbHelper extends BaseHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(ApplicationManager app) {
    super(app);
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

   public Users users() {
     Session session = sessionFactory.openSession();
     session.beginTransaction();
     List<UserData> users = session.createQuery( "from UserData" ).list();
     session.getTransaction().commit();
     session.close();
     return new Users(users);
   }
}
