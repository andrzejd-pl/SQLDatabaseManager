package com.dybowski_andrzej.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Collections;

import static java.util.Arrays.asList;

class MysqlConnectorTest {
    private static final String user = "test",
            password = "test",
            database = "northwind",
            host = "192.168.0.101";

    @Test
    void execute() {
        String goodQuery = "select * from customers where id = 1";
        Data goodData = new Data(
                asList("id",
                        "company",
                        "last_name",
                        "first_name",
                        "email_address",
                        "job_title",
                        "business_phone",
                        "home_phone",
                        "mobile_phone",
                        "fax_number",
                        "address",
                        "city",
                        "state_province",
                        "zip_postal_code",
                        "country_region",
                        "web_page",
                        "notes",
                        "attachments"
                ),
                Collections.singletonList(asList(
                        "1",
                        "Company A",
                        "Bedecs",
                        "Anna",
                        "null",
                        "Owner",
                        "(123)555-0100",
                        "null",
                        "null",
                        "(123)555-0101",
                        "123 1st Street",
                        "Seattle",
                        "WA",
                        "99999",
                        "USA",
                        "null",
                        "null",
                        ""
                )));
        MysqlConnector connector;
        try {
            connector = new MysqlConnector.Builder().setDatabaseName(database).setHost(host).setPassword(password).setUser(user).build();
            try {


                Data data = connector.execute(goodQuery);
                Assertions.assertIterableEquals(goodData.getColumns(), data.getColumns());
                Assertions.assertIterableEquals(goodData.getRows(), data.getRows());

            } catch (SQLException e) {
                e.printStackTrace();
                assert false;
            } finally {
                connector.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            assert false;
        }

    }
}