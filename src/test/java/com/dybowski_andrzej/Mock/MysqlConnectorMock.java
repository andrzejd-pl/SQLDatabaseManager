package com.dybowski_andrzej.Mock;

import com.dybowski_andrzej.Database.Data;
import com.dybowski_andrzej.Database.MysqlConnector;

import java.util.ArrayList;
import java.util.Arrays;

public class MysqlConnectorMock extends MysqlConnector {

     public MysqlConnectorMock(String host, String database, String user, String password) throws ClassNotFoundException {
        super(host, database, user, password);
    }

    @Override
    public void connect() {
    }

    @Override
    public void close() {
    }

    @Override
    public Data execute(String query) {
        return new Data(new ArrayList<>(Arrays.asList("id", "name", "telephone")), new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("1", "Jan Kowalski", "123456789")),
                new ArrayList<>(Arrays.asList("2", "Adam Nowak", "987654321")),
                new ArrayList<>(Arrays.asList("3", "Magda Kowalska", "456123789"))
        )));
    }

}
