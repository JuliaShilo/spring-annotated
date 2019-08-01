package org.itstep;

import org.itstep.config.AppConfig;
import org.itstep.dao.UserDAO;
import org.itstep.entity.Profile;
import org.itstep.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class ApplicationRunner
{
    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main( String[] args )
    {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)){

            User admin = new User();
            admin.setEmail("akira766@mail.ru");
            admin.setFirstName("Julia");
            admin.setLastName("Shilo");
            admin.setLogin("julia93");
            admin.setPassword("123456");
            admin.setProfile(Profile.ADMIN);

            User client = new User();
            client.setEmail("akira766@mail.ru");
            client.setFirstName("Julia");
            client.setLastName("Shilo");
            client.setLogin("julia93-client");
            client.setPassword("123456");
            client.setProfile(Profile.CLIENT);

            UserDAO userDAO = (UserDAO) context.getBean("userDAO");

            userDAO.saveOrUpdate(admin);
            userDAO.saveOrUpdate(client);

            LOG.info("DB has " + userDAO.findAll().size() + " rows in \"USER\" table");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
