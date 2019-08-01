package org.itstep.config;

import org.itstep.dao.UserDAO;
import org.itstep.dao.connection.ConnectionFactory;
import org.itstep.dao.connection.H2Factory;
import org.itstep.dao.connection.PostgresFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.itstep")
public class AppConfig {

    @Bean()
//    @Qualifier("h2Factory")
    @Primary
    public ConnectionFactory getH2Factory() {
        return new H2Factory();
    }

    @Bean()
//    @Primary
//    @Qualifier("postgresFactory")
    public ConnectionFactory getPostgresFactory() {
        return new PostgresFactory();
    }


    @Bean
    @Qualifier("userDAO")
    public UserDAO getUserDAO(ConnectionFactory connectionFactory) {
        UserDAO userDAO = new UserDAO();
        userDAO.setConnectionFactory(connectionFactory);
        return userDAO;
    }


}
