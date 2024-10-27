package ru.netology;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;

import static ru.netology.data.DataHelper.generateRandomLogin;
import static ru.netology.data.DataHelper.generateRandomPassword;
import static ru.netology.data.SQLHelper.*;

@Slf4j
public class DBUtilsDBTest {

    @BeforeEach
    void setUp() {
        SQLHelper.updateUsers(generateRandomLogin(), generateRandomPassword());
        SQLHelper.updateUsers(generateRandomLogin(), generateRandomPassword());
    }

    @Test
    void stubTest() {
        var count = countUsers();
        log.info(String.valueOf(count));
        var first = getFirstUser();
        log.info(first.toString());
        var all = getUsers();
        log.info(all.toString());
    }
}
