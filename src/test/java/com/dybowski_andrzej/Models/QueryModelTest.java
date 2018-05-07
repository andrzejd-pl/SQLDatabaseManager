package com.dybowski_andrzej.Models;

import com.dybowski_andrzej.Database.Data;
import com.dybowski_andrzej.Database.MysqlConnector;
import com.dybowski_andrzej.Exceptions.BadArgument;
import com.dybowski_andrzej.Mock.MysqlConnectorMock;
import com.dybowski_andrzej.Mock.ViewMock;
import com.dybowski_andrzej.Views.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class QueryModelTest {

    @Test
    void addObserverAndDeleteObserverAndNotifyObservers() {
        try {
            QueryModel model = null;
            View view = new ViewMock(model);
            model = new QueryModel.Builder().addConnector(new MysqlConnectorMock("test", "test", "test", "test")).addObserver(view).build();

            model.notifyObservers();

            model.deleteObserver(view);

            model.notifyObservers();

            model.addObserver(view);

            model.notifyObservers();
        } catch (BadArgument | ClassNotFoundException badArgument) {
            badArgument.printStackTrace();
        }
    }

    @Test
    void selectFromTable() {
        Data goodData = new Data(
                Arrays.asList("id",
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
                Collections.singletonList(Arrays.asList(
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
        try {
            QueryModel model = null;
            View view = new ViewMock(model);
            model = new QueryModel.Builder().addObserver(view).addConnector(new MysqlConnector("192.168.0.101", "northwind", "test", "test")).build();

            Data data = model.selectFromTable("customers", Collections.singletonList("*"), "id=1");

            Assertions.assertIterableEquals(goodData.getRows(), data.getRows());
            Assertions.assertIterableEquals(goodData.getColumns(), data.getColumns());
        } catch (BadArgument | ClassNotFoundException | SQLException badArgument) {
            badArgument.printStackTrace();
            assert false;
        }
    }

}