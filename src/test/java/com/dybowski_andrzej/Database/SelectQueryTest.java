package com.dybowski_andrzej.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectQueryTest {

    @Test
    void getQuery() {
        SelectQuery query = new SelectQuery("employees", Arrays.asList("id", "name"), "id = 5");

        Assertions.assertEquals("select id, name from employees where id = 5", query.getQuery());
    }
}