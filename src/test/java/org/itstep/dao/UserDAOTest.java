package org.itstep.dao;

import org.itstep.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    void getConnectionFactory() {
        assertNotNull(userDAO.getConnectionFactory());
        assertTrue(userDAO.getConnectionFactory().getClass().getSimpleName().equals("H2Factory"));
    }
}